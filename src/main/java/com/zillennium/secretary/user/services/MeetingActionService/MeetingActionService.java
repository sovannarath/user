package com.zillennium.secretary.user.services.MeetingActionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;

@Service
public class MeetingActionService implements MeetingActionServiceInterface {

	@Autowired
	private MeetingActionRepository repo;
	
	@Override
	public List<MeetingAction> all(long meeting_id) {
		return (List<MeetingAction>) repo.allMeetingActions(meeting_id);
	}

	@Override
	public Object get(long id) {
		return repo.findById(id);
	}

	@Override
	public MeetingAction create(MeetingAction action) {
		return repo.save(action);
	}

	@Override
	public MeetingAction update(MeetingAction action, long id) {
		action.setId(id);
		return repo.save(action);
	}

	@Override
	public Boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingAction> search(String str) {
		return null;
	}

}
