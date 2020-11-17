package com.zillennium.secretary.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.User;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> all() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Object getUser(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User update(User user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
