package com.zillennium.secretary.user.services.MeetingService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long>{
	
}
