package com.zillennium.secretary.user.services.MeetingGroupParticipantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingGroupParticipant;

@Service
public class MeetingGroupParticipantServiceImpl implements MeetingGroupParticipantService{

	@Autowired
	private MeetingGroupParticipantRepository repository;
	
	@Override
	public List<MeetingGroupParticipant> all() {
		// TODO Auto-generated method stub
		return (List<MeetingGroupParticipant>) repository.findAll();
	}

	@Override
	public Object get(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public MeetingGroupParticipant create(MeetingGroupParticipant userGroup) {
		// TODO Auto-generated method stub
		return repository.save(userGroup);
	}

	@Override
	public MeetingGroupParticipant update(MeetingGroupParticipant userGroup, long id) {
		// TODO Auto-generated method stub
		userGroup.setId(id);
		return repository.save(userGroup);
	}

	@Override
	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingGroupParticipant> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
