package com.example.dto;

import com.example.Entity.EntityPost;
import com.example.Entity.EntityUser;

public class DTOPost {
	public String userid;
	public String title;
	public String postValue;
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPostValue() {
		return postValue;
	}
	public void setPostValue(String postValue) {
		this.postValue = postValue;
	}
	
	
	
	@Override
	public String toString() {
		System.out.println("postValue : " + postValue);
		return "DtoPost [userid=" + userid + ", title=" + title + ", postValue = " + postValue + "]";
	}
	
	public EntityPost toEntity()
	{
		return new EntityPost(-1,
				this.userid, 
				this.title,
				this.postValue);
	}
}