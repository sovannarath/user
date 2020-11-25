package com.zillennium.secretary.user.services.OrganizationService;

import java.util.List;

import com.zillennium.secretary.user.models.Organization;

public interface OrganizationServiceInterface {
	public List<Organization> all();
	public Object get(long id);
	public Organization create(Organization organization);
	public Organization update(Organization organization, long id);
	public Boolean delete(long id);
	public List<Organization> search(String str);
}
