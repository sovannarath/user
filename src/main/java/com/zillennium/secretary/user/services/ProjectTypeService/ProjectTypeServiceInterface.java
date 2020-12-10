package com.zillennium.secretary.user.services.ProjectTypeService;

import java.util.List;

import com.zillennium.secretary.user.models.MeetingModels.ProjectType;

public interface ProjectTypeServiceInterface {
	public List<ProjectType> all();
	public Object get(long id);
	public ProjectType create(ProjectType type);
	public ProjectType update(ProjectType type, long id);
	public Boolean delete(long id);
	public List<ProjectType> search(String str);
}
