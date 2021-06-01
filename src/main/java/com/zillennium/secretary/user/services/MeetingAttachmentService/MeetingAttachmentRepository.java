package com.zillennium.secretary.user.services.MeetingAttachmentService;

import org.springframework.stereotype.Repository;
import com.zillennium.secretary.user.models.MeetingModels.MeetingAttachment;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface MeetingAttachmentRepository extends CrudRepository<MeetingAttachment, Long> {

}
