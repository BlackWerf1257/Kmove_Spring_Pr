package com.example.dto;

import com.example.Entity.EntityUser;

public class DTOUser {
	public String userid;
	public String userpw;
	public String email;
		
	public DTOUser()
	{
		
	}
	
	public DTOUser(String email, String userid, String userpw)
	{
		this.email = email;
		this.userid = userid;
		this.userpw = userpw;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "DtoUser [email=" + email +", userid=" + userid + ", userpw=" + userpw + "]";
	}
	
	public EntityUser toEntity()
	{
		return new EntityUser(-1,
				this.email,
				this.userid, 
				this.userpw);
	}
	
	
}
