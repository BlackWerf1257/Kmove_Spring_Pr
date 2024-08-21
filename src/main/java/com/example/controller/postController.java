package com.example.controller;


import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.DTOPost;
import com.example.dto.DTOUser;
import com.example.Entity.EntityPost;
import com.example.Entity.EntityUser;
import com.example.repository.RefoPost;
import com.example.repository.RefoUser;
@Controller
public class postController {	
	@Autowired
	RefoPost _repoPost;
	EntityPost entity;
	
	@GetMapping("DummyPost")
	public String SetDummy()
	{
		for(int i=0;i<10;i++)
		{
			_repoPost.save(new EntityPost(-1, 
					String.valueOf(i),
					String.valueOf(i), 
					String.valueOf(i)));
		}
		return "main";
	}
	
	
	@GetMapping(value = "/main")
	public String mainPage(Model m) {
		List<EntityPost> posts = _repoPost.NativeGetAllPost();
	    System.out.println("Fetched Posts: " + posts);
		m.addAttribute("items", posts);
		return "mainPage";
	}


	
	@GetMapping(value = "/newPost")
	public String newPost(@RequestParam(name = "userId", required = true) String id, Model m) {
		m.addAttribute("userId", id);
		//System.out.println(id);
		return "/postCreate";
	}
	@RequestMapping(value = "/PostCreate", method = RequestMethod.POST)
	public String PostCreate(DTOPost param)
	{	
		int result = _repoPost.newPost(param.userid, param.title, param.postValue);
	    //System.out.println("Number of rows affected: " + result);
	    
	    
	    // result가 0보다 크면 성공, 그렇지 않으면 실패
	    if(result > 0) {
	        return "redirect:/main";    
	    } else {
	        return "postCreateFailed";
	    }
	}
}

