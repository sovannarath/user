package com.zillennium.secretary.user.services.MeetingAgendaService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;

@Repository
public interface MeetingAgendaRepository extends CrudRepository<MeetingAgenda, Long>{

	@Query(value="SELECT * FROM meeting_agendas WHERE meeting_id = ?1", nativeQuery=true)
	List<MeetingAgenda> getAllAgendaByMeetingId(long meeting_id);
	
}
