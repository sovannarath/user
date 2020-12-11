package com.zillennium.secretary.user.services.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.UserRole;


@Service
public class RoleService implements RoleServiceInterface{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<UserRole> all() {
		// TODO Auto-generated method stub
		return (List<UserRole>) roleRepository.findAll();
	}

	@Override
	public Object getRole(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public UserRole create(UserRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public UserRole update(UserRole role, long id) {
		role.setId(id);
		return roleRepository.save(role);
	}

	@Override
	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
		return true;
	}

	@Override
	public List<UserRole> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
