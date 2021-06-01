package com.zillennium.secretary.user.services.MeetingAgendaService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;

@Repository
public interface MeetingAgendaRepository extends CrudRepository<MeetingAgenda, Long>{

}
