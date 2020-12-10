package com.zillennium.secretary.user.services.MeetingService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.Meeting;

public interface MeetingServiceInterface {
	public List<Meeting> all();
	public Object get(long id);
	public Meeting create(Meeting meeting);
	public Meeting update(Meeting meeting, long id);
	public Boolean delete(long id);
	public List<Meeting> search(String str);
}
