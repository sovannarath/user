package com.zillennium.secretary.user.services.ContactTypeService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.ContactType;

@Repository
public interface ContactTypeRepository extends CrudRepository<ContactType, Long>{

}
