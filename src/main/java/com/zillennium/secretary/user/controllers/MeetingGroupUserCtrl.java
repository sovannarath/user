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

import com.zillennium.secretary.user.models.MeetingModels.MeetingGroupParticipant;
import com.zillennium.secretary.user.services.MeetingGroupParticipantService.MeetingGroupParticipantServiceImpl;

@Controller
public class MeetingGroupUserCtrl {

	@Autowired
	private MeetingGroupParticipantServiceImpl service;

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user", method=RequestMethod.GET)
	public ResponseEntity<Object> index(@PathVariable("group_id") long id) {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("group_id") long group_id, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@PathVariable("group_id") long group_id, @RequestBody MeetingGroupParticipant user) {
		return new ResponseEntity<>(service.create(user), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable("group_id") long group_id, @RequestBody MeetingGroupParticipant user, long id) {
		return new ResponseEntity<>(service.update(user, id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("group_id") long group_id, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-group/{group_id}/user/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(String str) {
		return null;
	}

}
