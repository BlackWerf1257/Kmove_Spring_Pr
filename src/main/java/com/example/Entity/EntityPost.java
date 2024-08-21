package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String userid;

	@Column
	String title;
	
	@Column
	String postValue;
	
	
	public EntityPost()
	{
		
	}
	
	public EntityPost(int id, String usrid, String title, String postValue) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.postValue = postValue;
	}


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
	
	
	
	
	
	
}
