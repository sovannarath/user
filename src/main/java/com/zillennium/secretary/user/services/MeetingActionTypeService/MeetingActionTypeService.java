package com.zillennium.secretary.user.services.MeetingActionTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingActionType;


@Service
public class MeetingActionTypeService implements MeetingActionTypeServiceInterface {

	@Autowired
	private MeetingActionTypeRepository repo;
	
	@Override
	public List<MeetingActionType> all() {
		return (List<MeetingActionType>) repo.findAll();
	}

	@Override
	public Object get(long id) {
		return repo.findById(id);
	}

	@Override
	public MeetingActionType create(MeetingActionType type) {
		return repo.save(type);
	}

	@Override
	public MeetingActionType update(MeetingActionType type, long id) {
		type.setId(id);
		return repo.save(type);
	}

	@Override
	public Boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingActionType> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
