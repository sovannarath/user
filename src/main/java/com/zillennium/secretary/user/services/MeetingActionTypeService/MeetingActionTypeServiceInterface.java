package com.zillennium.secretary.user.services.MeetingActionTypeService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingActionType;

public interface MeetingActionTypeServiceInterface {
	public List<MeetingActionType> all();
	public Object get(long id);
	public MeetingActionType create(MeetingActionType type);
	public MeetingActionType update(MeetingActionType type, long id);
	public Boolean delete(long id);
	public List<MeetingActionType> search(String str);
}
