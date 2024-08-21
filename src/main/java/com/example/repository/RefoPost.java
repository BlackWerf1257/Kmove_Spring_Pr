package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Entity.EntityPost;

import jakarta.transaction.Transactional;

@Repository
public interface RefoPost extends CrudRepository<EntityPost, Integer> {
	@Query(value = "SELECT * FROM Entity_Post", nativeQuery = true)
	List<EntityPost> NativeGetAllPost();
	@Query(value = "SELECT * FROM Entity_Post WHERE USERID = :userid", nativeQuery = true)
	List<EntityPost> NativeGetAllMyPost(@Param("userid") String userid);



	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO ENTITY_POST (id, userid, title, post_Value) SELECT COALESCE(MAX(id), 0) + 1, :uid, :title, :postValue FROM ENTITY_POST;", nativeQuery = true)
    int newPost(String uid, String title, String postValue);
}
