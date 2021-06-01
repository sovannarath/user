package com.zillennium.secretary.user.services.MeetingParticipantGroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipantGroup;

@Service
public class MeetingParticipantGroupServiceImpl implements MeetingParticipantGroupService {

	@Autowired
	private MeetingParticipantGroupRepository repository;
	
	@Override
	public List<MeetingParticipantGroup> all() {
		// TODO Auto-generated method stub
		return (List<MeetingParticipantGroup>) repository.findAll();
	}

	@Override
	public Object get(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public MeetingParticipantGroup create(MeetingParticipantGroup participantGroup) {
		// TODO Auto-generated method stub
		return repository.save(participantGroup);
	}

	@Override
	public MeetingParticipantGroup update(MeetingParticipantGroup participantGroup, long id) {
		// TODO Auto-generated method stub
		participantGroup.setId(id);
		return repository.save(participantGroup);
	}

	@Override
	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingParticipantGroup> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
