package com.zillennium.secretary.user.services;

import java.util.List;

import com.zillennium.secretary.user.models.User;

public interface UserServiceInterface {
	public List<User> all();
	public Object getUser(long id);
	public User create(User user);
	public User update(User user, long id);
	public Boolean delete(long id);
}
