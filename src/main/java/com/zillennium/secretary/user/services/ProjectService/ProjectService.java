package com.zillennium.secretary.user.services.ProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillennium.secretary.user.models.MeetingModels.Project;

@Service
public class ProjectService implements ProjectServiceInterface {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> all() {
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Object get(long id) {
		return projectRepository.findById(id);
	}

	@Override
	public Project create(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project, long id) {
		project.setId(id);
		return projectRepository.save(project);
	}

	@Override
	public Boolean delete(long id) {
		projectRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Project> search(String str) {
		
		return null;
	}

}
