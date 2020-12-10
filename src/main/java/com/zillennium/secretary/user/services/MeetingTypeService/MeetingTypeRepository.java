package com.zillennium.secretary.user.services.MeetingTypeService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingType;

@Repository
public interface MeetingTypeRepository extends CrudRepository<MeetingType, Long> {

}
