package com.zillennium.secretary.user.services.ProjectTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.ProjectType;

@Service
public class ProjectTypeService implements ProjectTypeServiceInterface {

	@Autowired
	private ProjectTypeRepository typeRepository;
	
	@Override
	public List<ProjectType> all() {
		return (List<ProjectType>) typeRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return typeRepository.findById(id);
	}

	@Override
	public ProjectType create(ProjectType type) {
		return typeRepository.save(type);
	}

	@Override
	public ProjectType update(ProjectType type, long id) {
		type.setId(id);
		return typeRepository.save(type);
	}

	@Override
	public Boolean delete(long id) {
		typeRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ProjectType> search(String str) {
		return null;
	}

}
