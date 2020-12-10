package com.zillennium.secretary.user.services.ProjectTypeService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.ProjectType;

@Repository
public interface ProjectTypeRepository extends CrudRepository<ProjectType, Long> {
	
}
