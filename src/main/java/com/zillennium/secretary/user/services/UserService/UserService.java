package com.zillennium.secretary.user.services.UserService;

import java.util.List;

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
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
		return userRepository.save(user);
	}

	@Override
	public User update(User user, long id) {
		//System.out.println(user.getRole().getId());
		user.setId(id);
		return userRepository.save(user);
		//return null;
	}

	@Override
	public Boolean delete(long id) {
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public List<User> search(String str){
		/*String splits[] = str.split(" ");
		String sqlCondition = "";
		for(int i=0; i < splits.length; i++) {
			String tmpStr = "";
			if(i == 0) {
				tmpStr = " name LIKE %" + splits[i] + "%";
			}else {
				tmpStr = " AND (SELECT 1 FROM user_contact WHERE users.id = user_contact.user_id AND (SELECT 1 FROM contact_provider WHERE user_contact.provider_id = contact_provider.id AND contact_provider.name LIKE %" + splits[i] + "%))";
			}
			sqlCondition += tmpStr + " ";
		}
		System.out.println(sqlCondition);*/
		return userRepository.search(str);
	}

}
