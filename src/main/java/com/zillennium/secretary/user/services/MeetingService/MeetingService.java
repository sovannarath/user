package com.zillennium.secretary.user.services.MeetingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.Meeting;

@Service
public  class MeetingService implements MeetingServiceInterface {

	@Autowired
	private MeetingRepository meetingRepo;
	
	@Override
	public List<Meeting> all() {
		return (List<Meeting>) meetingRepo.findAll();
	}

	@Override
	public Object get(long id) {
		return meetingRepo.findById(id);
	}

	@Override
	public Meeting create(Meeting meeting) {
		return meetingRepo.save(meeting);
	}

	@Override
	public Meeting update(Meeting meeting, long id) {
		meeting.setId(id);
		return meetingRepo.save(meeting);
	}

	@Override
	public Boolean delete(long id) {
		meetingRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Meeting> search(String str) {
		return null;
	}

}
