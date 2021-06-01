package com.zillennium.secretary.user.services.MeetingParticipantGroup;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipantGroup;

public interface MeetingParticipantGroupService {
	public List<MeetingParticipantGroup> all();
	public Object get(long id);
	public MeetingParticipantGroup create(MeetingParticipantGroup participantGroup);
	public MeetingParticipantGroup update(MeetingParticipantGroup participantGroup, long id);
	public Boolean delete(long id);
	public List<MeetingParticipantGroup> search(String str);
}
