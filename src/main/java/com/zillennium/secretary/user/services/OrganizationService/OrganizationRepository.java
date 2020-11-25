package com.zillennium.secretary.user.services.OrganizationService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{

}
