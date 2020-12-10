package com.zillennium.secretary.user.services.ProjectService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{

}
