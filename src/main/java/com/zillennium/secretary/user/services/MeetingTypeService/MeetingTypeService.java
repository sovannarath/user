package com.zillennium.secretary.user.services.MeetingTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.MeetingType;

@Service
public class MeetingTypeService implements MeetingTypeServiceInterface {

	@Autowired
	private MeetingTypeRepository typeRepo;
	
	@Override
	public List<MeetingType> all() {
		return (List<MeetingType>) typeRepo.findAll();
	}

	@Override
	public Object get(long id) {
		return typeRepo.findById(id);
	}

	@Override
	public MeetingType create(MeetingType type) {
		return typeRepo.save(type);
	}

	@Override
	public MeetingType update(MeetingType type, long id) {
		type.setId(id);
		return typeRepo.save(type);
	}

	@Override
	public Boolean delete(long id) {
		typeRepo.deleteById(id);
		return true;
	}

	@Override
	public List<MeetingType> search(String str) {
		return null;
	}

}
