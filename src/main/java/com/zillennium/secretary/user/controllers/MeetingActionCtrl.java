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

import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;
import com.zillennium.secretary.user.services.MeetingActionService.MeetingActionService;

@RestController
public class MeetingActionCtrl {

	@Autowired
	private MeetingActionService service;

	@CrossOrigin
	@RequestMapping(value="/current-meeting-actions/{meeting_id}", method=RequestMethod.GET)
	public ResponseEntity<Object> index(@PathVariable("meeting_id") long meeting_id) {
		return new ResponseEntity<>(service.all(meeting_id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-actions/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-actions", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MeetingAction meetingAction) {
		return new ResponseEntity<>(service.create(meetingAction), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-actions/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingAction meetingAction, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.update(meetingAction, id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-actions", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-actions/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str) {
		return null;
	}
	
}
