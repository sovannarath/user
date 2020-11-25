package com.zillennium.secretary.user.services.UserContactService;

import java.util.List;

import com.zillennium.secretary.user.models.UserContact;

public interface UserContactServiceInterface {
	public List<UserContact> all();
	public Object get(long id);
	public UserContact create(UserContact contact);
	public UserContact update(UserContact contact, long id);
	public Boolean delete(long id);
	public List<UserContact> search(String str);
}
