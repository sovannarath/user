package com.zillennium.secretary.user.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	@Query(value="SELECT * FROM users WHERE name LIKE %:str% OR email LIKE %:str% OR phone_number LIKE %:str% OR position LIKE %:str%", nativeQuery=true)
	List<User> search(@Param("str")String str);
	
}
