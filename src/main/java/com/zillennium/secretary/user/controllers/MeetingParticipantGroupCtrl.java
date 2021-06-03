package com.zillennium.secretary.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipantGroup;
import com.zillennium.secretary.user.services.MeetingParticipantGroup.MeetingParticipantGroupServiceImpl;

@Controller
public class MeetingParticipantGroupCtrl {
	
	@Autowired
	private MeetingParticipantGroupServiceImpl service;
	
	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MeetingParticipantGroup group) {
		return new ResponseEntity<>(service.create(group), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingParticipantGroup group, long id) {
		return new ResponseEntity<>(service.update(group, id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-participant-groups/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(String str) {
		return null;
	}
	
}
