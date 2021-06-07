package com.zillennium.secretary.user.services.MeetingAgendaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;
import com.zillennium.secretary.user.services.MeetingAgendaService.MeetingAgendaRepository;

@Service
public class MeetingAgendaService implements MeetingAgendaInterface{

	@Autowired
	private MeetingAgendaRepository meetingAgendaRepo;
	
	@Override
	public List<MeetingAgenda> all() {
		// TODO Auto-generated method stub
		return (List<MeetingAgenda>) meetingAgendaRepo.findAll();
	}

	@Override
	public Object get(long id) {
		// TODO Auto-generated method stub
		return meetingAgendaRepo.findById(id);
	}

	@Override
	public MeetingAgenda create(MeetingAgenda meetingAgenda) {
		// TODO Auto-generated method stub
		return meetingAgendaRepo.save(meetingAgenda);
	}

	@Override
	public MeetingAgenda update(MeetingAgenda meetingAgenda, long id) {
		// TODO Auto-generated method stub
		meetingAgenda.setId(id);
		return meetingAgendaRepo.save(meetingAgenda);
	}

	@Override
	public Boolean delete(long id) {
		meetingAgendaRepo.deleteById(id);
		return null;
	}

	@Override
	public List<MeetingAgenda> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeetingAgenda> getAllAgendaByMeetingId(long meeting_id) {
		// TODO Auto-generated method stub
		return meetingAgendaRepo.getAllAgendaByMeetingId(meeting_id);
	}

}
