package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String userid;
	
	@Column
	String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	String userpw;

	
	public EntityUser()
	{
		
	}
	
	public EntityUser(int id, String email, String userid, String userpw) {
		super();
		this.id = id;
		this.email = email;
		this.userid = userid;
		this.userpw = userpw;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
	
	
}
