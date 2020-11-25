package com.zillennium.secretary.user.services.UserContactService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.UserContact;

@Repository
public interface UserContactRepository extends CrudRepository<UserContact, Long>{

}
