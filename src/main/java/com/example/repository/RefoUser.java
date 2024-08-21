package com.example.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Entity.EntityUser;

import jakarta.transaction.Transactional;

@Repository
public interface RefoUser extends CrudRepository<EntityUser, Integer> {

	@Query("Select u from EntityUser u where u.userid = :userid and u.userpw = :userpw")
	public EntityUser findByUseridAndUserpw(String userid, String userpw);
	
	@Query("Select u from EntityUser u where u.userid = ?1 and u.userpw = ?2")
	   public EntityUser UseridAndUserpw(String uid, String upw);
	
	@Query(value = "SELECT * FROM Entity_User " + 
			"WHERE USERID = :userid AND USERPW = :userpw", nativeQuery = true)
	public EntityUser NativeUserIdAndUserPw(String userid, String userpw);
	
	@Query(value = "SELECT * FROM Entity_User " + 
			"WHERE USERID = :userid AND USERPW = :userpw", nativeQuery = true)
	public EntityUser NativeUserLogin(String userid, String userpw);

	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ENTITY_USER (id, email, userid, userpw) SELECT COALESCE(MAX(id), 0) + 1, :email, :uid, :upw FROM entity_user;", nativeQuery = true)
    int joinUser(String email, String uid, String upw);


	
	/*@Modifying
	@Query(value = "INSERT INTO EntityUser(id, userid, userpw) values(5, :uid, :upw)", nativeQuery = true)
	public EntityUser NativeRegister(String uid, String upw);*/

	
	//엔티티를 보고 할 경우 사용
	//@Query("Select u from EntityUser u where u.userid = ?1 and u.userpw = ?2")
	//   public EntityUser UseridAndUserpw(String uid, String upw);
	
}
