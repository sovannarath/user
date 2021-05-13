package com.zillennium.secretary.user.services.MeetingActionService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;

@Repository
public interface MeetingActionRepository extends CrudRepository<MeetingAction, Long> {

	@Query(value = "SELECT * FROM meeting_actions ma WHERE ma.meeting_id = ?1", nativeQuery = true)
	List<MeetingAction> allMeetingActions(long meeting_id);
	
}
