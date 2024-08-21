package com.example.dto;



public class DTOuserinfo {
	public String id;
	public String pw;
	public String age;
	public String gender;
	public String mail;
	
	
	
	@Override
	public String toString() {
		return "DTOuserinfo [id=" + id + ", pw=" + pw + ", age=" + age + ", gender=" + gender + ", mail=" + mail + "]";
	}

	public DTOuserinfo() {
		
	}
	
	public DTOuserinfo(String id, String pw, String age, String gender, String mail) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.gender = gender;
		this.mail = mail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
