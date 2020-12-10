package com.zillennium.secretary.user.services.UserInvolvedMeetingService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipant;

public interface MeetingParticipantServiceInterface {
	public List<MeetingParticipant> all();
	public Object get(long id);
	public MeetingParticipant create(MeetingParticipant paticipant);
	public MeetingParticipant update(MeetingParticipant paticipant, long id);
	public Boolean delete(long id);
	public List<MeetingParticipant> search(String str);
}
