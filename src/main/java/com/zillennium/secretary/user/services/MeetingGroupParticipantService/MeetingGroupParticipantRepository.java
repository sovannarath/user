package com.zillennium.secretary.user.services.MeetingGroupParticipantService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingGroupParticipant;

@Repository
public interface MeetingGroupParticipantRepository extends CrudRepository<MeetingGroupParticipant, Long> {

}
