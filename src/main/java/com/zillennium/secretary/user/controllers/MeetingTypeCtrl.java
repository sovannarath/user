package com.zillennium.secretary.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zillennium.secretary.user.models.MeetingModels.MeetingType;
import com.zillennium.secretary.user.services.MeetingTypeService.MeetingTypeService;

@RestController
public class MeetingTypeCtrl {

	@Autowired
	private MeetingTypeService service;
	
	@RequestMapping(value="/meeting-types", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-types/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-types", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MeetingType meetingType) {
		return new ResponseEntity<>(service.create(meetingType), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-types/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingType meetingType, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.update(meetingType, id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-types/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-types/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str) {
		return null;
	}

}
