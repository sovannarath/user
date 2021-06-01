package com.zillennium.secretary.user.services.MeetingParticipantGroup;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipantGroup;

@Repository
public interface MeetingParticipantGroupRepository extends CrudRepository<MeetingParticipantGroup, Long> {

}
