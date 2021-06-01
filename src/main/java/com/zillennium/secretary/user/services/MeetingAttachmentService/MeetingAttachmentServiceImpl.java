package com.zillennium.secretary.user.services.MeetingAttachmentService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAttachment;

@Service
public class MeetingAttachmentServiceImpl implements MeetingAttachmentService{

	@Autowired
	private MeetingAttachmentRepository repository;
	
	@Override
	public List<MeetingAttachment> all() {
		// TODO Auto-generated method stub
		return (List<MeetingAttachment>) repository.findAll();
	}

	@Override
	public Object get(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public MeetingAttachment create(MeetingAttachment attach) {
		// TODO Auto-generated method stub
		
		return repository.save(attach);
	}

	@Override
	public MeetingAttachment update(MeetingAttachment attach, long id) {
		// TODO Auto-generated method stub
		attach.setId(id);
		return repository.save(attach);
	}

	@Override
	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingAttachment> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
