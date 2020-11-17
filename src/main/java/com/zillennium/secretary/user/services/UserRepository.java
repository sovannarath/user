package com.zillennium.secretary.user.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

}
