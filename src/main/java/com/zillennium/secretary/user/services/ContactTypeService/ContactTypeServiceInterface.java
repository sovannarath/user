package com.zillennium.secretary.user.services.ContactTypeService;

import java.util.List;

import com.zillennium.secretary.user.models.ContactType;

public interface ContactTypeServiceInterface {
	public List<ContactType> all();
	public Object get(long id);
	public ContactType create(ContactType type);
	public ContactType update(ContactType type, long id);
	public Boolean delete(long id);
	public List<ContactType> search(String str);
}
