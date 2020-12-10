package com.zillennium.secretary.user.services.ProjectService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.Project;

public interface ProjectServiceInterface {
	public List<Project> all();
	public Object get(long id);
	public Project create(Project project);
	public Project update(Project project, long id);
	public Boolean delete(long id);
	public List<Project> search(String str);
}
