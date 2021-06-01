package com.zillennium.secretary.user.services.MeetingAttachmentService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAttachment;

public interface MeetingAttachmentService {
	public List<MeetingAttachment> all();
	public Object get(long id);
	public MeetingAttachment create(MeetingAttachment attach);
	public MeetingAttachment update(MeetingAttachment attach, long id);
	public Boolean delete(long id);
	public List<MeetingAttachment> search(String str);
}
