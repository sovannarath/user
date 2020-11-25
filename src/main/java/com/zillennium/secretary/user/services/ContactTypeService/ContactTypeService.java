package com.zillennium.secretary.user.services.ContactTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.ContactType;

@Service
public class ContactTypeService implements ContactTypeServiceInterface{
	
	@Autowired
	private ContactTypeRepository contactTypeRepository;

	@Override
	public List<ContactType> all() {
		return (List<ContactType>) contactTypeRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return contactTypeRepository.findById(id);
	}

	@Override
	public ContactType create(ContactType type) {
		return contactTypeRepository.save(type);
	}

	@Override
	public ContactType update(ContactType type, long id) {
		type.setId(id);
		return contactTypeRepository.save(type);
	}

	@Override
	public Boolean delete(long id) {
		contactTypeRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ContactType> search(String str) {
		return null;
	}
	
}
