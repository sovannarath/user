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

import com.zillennium.secretary.user.models.MeetingModels.MeetingActionType;
import com.zillennium.secretary.user.services.MeetingActionTypeService.MeetingActionTypeService;

@RestController
public class MeetingActionTypeCtrl{

	@Autowired
	private MeetingActionTypeService service;
	
	@CrossOrigin
	@RequestMapping(value="/meeting-action-types", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-action-types/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-action-types", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MeetingActionType meetingActionType) {
		return new ResponseEntity<>(service.create(meetingActionType), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-action-types/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingActionType meetingActionType, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.update(meetingActionType, id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-action-types/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-action-types/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam String str) {
		return null;
	}

}
