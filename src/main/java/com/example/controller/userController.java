package com.example.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.DTOPost;
import com.example.dto.DTOUser;
import com.example.Entity.EntityUser;
import com.example.repository.RefoPost;
import com.example.repository.RefoUser;
@Controller
public class userController {	
	@Autowired
	RefoUser _repoUser;
	
	
	
	@GetMapping("DummyUser")
	public String SetDummy()
	{
		for(int i=0;i<10;i++)
		{
			_repoUser.save(new EntityUser(-1, 
					String.valueOf(i),
					String.valueOf(i), 
					String.valueOf(i)));
		}
		return "mainPage";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Register(DTOUser param)
	{	
	    int result = _repoUser.joinUser(param.email, param.userid, param.userpw);
	    //System.out.println("Number of rows affected: " + result);
	    
	   /* System.out.println(param.email);
	    System.out.println(param.userid);
	    System.out.println(param.userpw);*/
	    
	    // result가 0보다 크면 성공, 그렇지 않으면 실패
	    if(result > 0) {
	        return "registerSucceed";    
	    } else {
	        return "/registerForm";
	    }
}
	
	@GetMapping("/registerForm")
	public String registerForm(Model m) {
		m.addAttribute("title", "회원가입");
		m.addAttribute("action", "/register");
		m.addAttribute("isLogin", "false");
		
		return "JoinLogin";
	}
	
	@GetMapping("/loginForm")
	public String loginForm(Model m)
	{
		m.addAttribute("title", "로그인");
		m.addAttribute("action", "/login");
		m.addAttribute("isLogin", "true");
		
		return "JoinLogin";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "index";
	}
	
	/*@GetMapping("registerForm")
	public String registerForm(DTOUser param) {
		return "join";
	}*/
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login( DTOUser param, Model m)
	{	
		EntityUser user = _repoUser.NativeUserLogin(param.userid, param.userpw);
		//EntityUser user = _repoUser.findByUseridAndUserpw(param.userid, param.userpw);
		//EntityUser user = _repoUser.UseridAndUserpw(param.userid, param.userpw);
		
		
		//System.out.println("User : " + user.getUserid());
		
		if(user != null)
		{
			m.addAttribute("userId", param.userid);
			return "redirect:/main";			
		}
		else
			return "doRegister";
	}
	

	@GetMapping("/login/{id}")	
	public String login( @PathVariable int id)
	{	
		Optional<EntityUser> eu =  _repoUser.findById(id);
		
		if(eu.isPresent())
		{			
			EntityUser user = (EntityUser)eu.get();
			
			System.out.println(user.getId());
			System.out.println(user.getUserid());
			System.out.println(user.getUserpw());
			return "mypage";			
		}
		else
		{
			return "index";
		}	
	}
	
	@PostMapping("/PostTest")
	@ResponseBody
	public String post( DTOUser param)
	{	
		_repoUser.save(param.toEntity());
		
		System.out.println(param.toString());
		return param.toString();
		
//		if(param.equals("1"))
//		{
//			return ResponseEntity.ok("요청이 정상적으로 완료됨");
//			//return new Re.("요청이 정상적으로 완료됨");
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("잘못된 경로로 거부");
//		}
	}

}