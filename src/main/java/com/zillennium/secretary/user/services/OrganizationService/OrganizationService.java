package com.zillennium.secretary.user.services.OrganizationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.Organization;

@Service
public class OrganizationService implements OrganizationServiceInterface{

	@Autowired
	private OrganizationRepository orgRepository;
	
	@Override
	public List<Organization> all() {
		return (List<Organization>) orgRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return orgRepository.findById(id);
	}

	@Override
	public Organization create(Organization organization) {
		return orgRepository.save(organization);
	}

	@Override
	public Organization update(Organization organization, long id) {
		organization.setId(id);
		return orgRepository.save(organization);
	}

	@Override
	public Boolean delete(long id) {
		orgRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Organization> search(String str) {
		return null;
	}

}
