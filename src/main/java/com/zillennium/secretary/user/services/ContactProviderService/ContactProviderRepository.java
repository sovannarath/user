package com.zillennium.secretary.user.services.ContactProviderService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.ContactProvider;

@Repository
public interface ContactProviderRepository extends CrudRepository<ContactProvider, Long>{

}
