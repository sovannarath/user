package com.zillennium.secretary.user.services.UserInvolvedMeetingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipant;

@Service
public class MeetingParticipantService implements MeetingParticipantServiceInterface {

	@Autowired
	private MeetingParticipantRepository repo;
	
	@Override
	public List<MeetingParticipant> all() {
		return (List<MeetingParticipant>) repo.findAll();
	}

	@Override
	public Object get(long id) {
		return repo.findById(id);
	}

	@Override
	public MeetingParticipant create(MeetingParticipant paticipant) {
		return repo.save(paticipant);
	}

	@Override
	public MeetingParticipant update(MeetingParticipant paticipant, long id) {
		paticipant.setId(id);
		return repo.save(paticipant);
	}

	@Override
	public Boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingParticipant> search(String str) {
		return null;
	}

}
