package com.zillennium.secretary.user.services.MeetingActionTypeService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingActionType;

@Repository
public interface MeetingActionTypeRepository extends CrudRepository<MeetingActionType, Long> {

}
