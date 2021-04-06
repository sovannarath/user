package com.zillennium.secretary.user.services.UserService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	@Query(value="SELECT * FROM users WHERE name LIKE %?1%", nativeQuery=true)
	List<User> search(String search);
	
}
