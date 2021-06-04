package com.zillennium.secretary.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipant;
import com.zillennium.secretary.user.services.UserInvolvedMeetingService.MeetingParticipantService;

@RestController
@CrossOrigin("http://localhost:8081")
public class MeetingPaticipantCtrl {

	@Autowired
	private MeetingParticipantService service;

	@RequestMapping(value="/meeting/{meeting_id}/participants", method=RequestMethod.GET)
	public ResponseEntity<Object> index(@PathVariable("meeting_id") long meeting_id) {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting/{meeting_id}/participants/{user_id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("meeting_id") long meeting_id, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting/{meeting_id}/participants/{user_id}", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@PathVariable("meeting_id") long meeting_id, @RequestBody MeetingParticipant meetingParticipant) {
		return new ResponseEntity<>(service.create(meetingParticipant), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting/{meeting_id}/participants/{user_id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable("meeting_id") long meeting_id, @RequestBody MeetingParticipant meetingParticipant, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.update(meetingParticipant, id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting/{meeting_id}/participants/{user_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("meeting_id") long meeting_id, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting/{meeting_id}/participants/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@PathVariable("meeting_id") long meeting_id, @RequestParam("search") String str) {
		return null;
	}

}
