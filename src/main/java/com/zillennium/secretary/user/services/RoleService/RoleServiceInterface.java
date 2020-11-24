package com.zillennium.secretary.user.services.RoleService;

import java.util.List;

import com.zillennium.secretary.user.models.UserRole;

public interface RoleServiceInterface {
	public List<UserRole> all();
	public Object getRole(long id);
	public UserRole create(UserRole role);
	public UserRole update(UserRole role, long id);
	public Boolean delete(long id);
	public List<UserRole> search(String str);
	
}
