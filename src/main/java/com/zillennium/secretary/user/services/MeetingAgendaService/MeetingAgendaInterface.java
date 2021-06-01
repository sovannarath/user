package com.zillennium.secretary.user.services.MeetingAgendaService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;

public interface MeetingAgendaInterface {
	public List<MeetingAgenda> all();
	public Object get(long id);
	public MeetingAgenda create(MeetingAgenda meeting);
	public MeetingAgenda update(MeetingAgenda meeting, long id);
	public Boolean delete(long id);
	public List<MeetingAgenda> search(String str);
}
