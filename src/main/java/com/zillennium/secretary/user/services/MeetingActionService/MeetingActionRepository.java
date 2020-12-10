package com.zillennium.secretary.user.services.MeetingActionService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;

@Repository
public interface MeetingActionRepository extends CrudRepository<MeetingAction, Long> {

}
