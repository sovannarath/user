package com.zillennium.secretary.user.services.MeetingTypeService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingType;

public interface MeetingTypeServiceInterface {
	public List<MeetingType> all();
	public Object get(long id);
	public MeetingType create(MeetingType type);
	public MeetingType update(MeetingType type, long id);
	public Boolean delete(long id);
	public List<MeetingType> search(String str);
}
