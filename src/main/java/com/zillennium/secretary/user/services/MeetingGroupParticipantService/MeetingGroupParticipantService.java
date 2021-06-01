package com.zillennium.secretary.user.services.MeetingGroupParticipantService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingGroupParticipant;

public interface MeetingGroupParticipantService {
	public List<MeetingGroupParticipant> all();
	public Object get(long id);
	public MeetingGroupParticipant create(MeetingGroupParticipant userGroup);
	public MeetingGroupParticipant update(MeetingGroupParticipant userGroup, long id);
	public Boolean delete(long id);
	public List<MeetingGroupParticipant> search(String str);
}
