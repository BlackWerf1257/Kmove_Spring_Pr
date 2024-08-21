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
public class mainController {	
	@RequestMapping(value= "/message", method = RequestMethod.GET)	
	@ResponseBody
	public String getMessage()
	{
		return "adslifkjsdlfj";
	}
	
	//@GetMapping("/hi")	
	@RequestMapping(value= "/hi", method = RequestMethod.GET)	
	public String getHi(Model m)
	{
		m.addAttribute("value", "백석대학교");
		return "hi";
	}
	
	@GetMapping("/param/{id}/{id2}")
	@ResponseBody
	public String setParam(@PathVariable int id, @PathVariable int id2)
	{
		
		return String.valueOf(id ) + "  " +String.valueOf(id2 );
	}
	
	@GetMapping("/reTest/{param}")
	@ResponseBody
	public ResponseEntity<String> responseEntityTest(@PathVariable int param)
	{
		if(param == 1)
		{
			return ResponseEntity.ok("요청이 정상적으로 완료됨");
			//return new Re.("요청이 정상적으로 완료됨");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("잘못된 경로로 거부");
		}
	
	}
	
	
	@PostMapping("/PostTest1")
	@ResponseBody
	public String post1( String userpw)
	{	
		System.out.println(userpw);
		return userpw;
		
	}

	
	/*@GetMapping(value = "/mainPage")
	public String mainPage() {
		return "/mainPage";
	}
	@GetMapping(value = "/newPost")
	public String newPost() {
		return "/postCreate";
	}
	@RequestMapping(value = "/PostCreate", method = RequestMethod.POST)
	public String PostCreate(DTOPost param)
	{	
		int result = _repoPost.newPost(param.userid, param.title, param.postValue);
	    System.out.println("Number of rows affected: " + result);
	    
	    
	    // result가 0보다 크면 성공, 그렇지 않으면 실패
	    if(result > 0) {
	        return "/mypage";    
	    } else {
	        return "/home";
	    }
	}*/
	
	
	
	
}

