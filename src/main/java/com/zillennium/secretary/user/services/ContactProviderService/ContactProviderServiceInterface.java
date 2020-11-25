package com.zillennium.secretary.user.services.ContactProviderService;

import java.util.List;

import com.zillennium.secretary.user.models.ContactProvider;

public interface ContactProviderServiceInterface {
	public List<ContactProvider> all();
	public Object get(long id);
	public ContactProvider create(ContactProvider provider);
	public ContactProvider update(ContactProvider provider, long id);
	public Boolean delete(long id);
	public List<ContactProvider> search(String str);
}
