package com.zillennium.secretary.user.services.MeetingActionService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;

public interface MeetingActionServiceInterface {
	public List<MeetingAction> all(long meeting_id);
	public Object get(long id);
	public MeetingAction create(MeetingAction action);
	public MeetingAction update(MeetingAction action, long id);
	public Boolean delete(long id);
	public List<MeetingAction> search(String str);
}
