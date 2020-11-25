package com.zillennium.secretary.user.services.ContactProviderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.ContactProvider;

@Service
public class ContactProviderService implements ContactProviderServiceInterface{

	@Autowired
	private ContactProviderRepository contactProviderRepository;
	
	@Override
	public List<ContactProvider> all() {
		return (List<ContactProvider>) contactProviderRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return contactProviderRepository.findById(id);
	}

	@Override
	public ContactProvider create(ContactProvider provider) {
		return contactProviderRepository.save(provider);
	}

	@Override
	public ContactProvider update(ContactProvider provider, long id) {
		provider.setId(id);
		return contactProviderRepository.save(provider);
	}

	@Override
	public Boolean delete(long id) {
		contactProviderRepository.deleteById(id);;
		return true;
	}

	@Override
	public List<ContactProvider> search(String str) {
		return null;
	}

}
