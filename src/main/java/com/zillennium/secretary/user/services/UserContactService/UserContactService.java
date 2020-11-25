package com.zillennium.secretary.user.services.UserContactService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.UserContact;

@Service
public class UserContactService implements UserContactServiceInterface {

	@Autowired
	private UserContactRepository userContactRepository;
	
	@Override
	public List<UserContact> all() {
		return (List<UserContact>) userContactRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return userContactRepository.findById(id);
	}

	@Override
	public UserContact create(UserContact contact) {
		return userContactRepository.save(contact);
	}

	@Override
	public UserContact update(UserContact contact, long id) {
		contact.setId(id);
		return userContactRepository.save(contact);
	}

	@Override
	public Boolean delete(long id) {
		userContactRepository.deleteById(id);
		return true;
	}

	@Override
	public List<UserContact> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
