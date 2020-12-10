package com.zillennium.secretary.user.services.UserInvolvedMeetingService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipant;

@Repository
public interface MeetingParticipantRepository extends CrudRepository<MeetingParticipant, Long> {

}
