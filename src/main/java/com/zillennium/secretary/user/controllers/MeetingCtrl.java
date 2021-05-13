package com.zillennium.secretary.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zillennium.secretary.user.models.MeetingModels.Meeting;
import com.zillennium.secretary.user.services.MeetingService.MeetingService;

@RestController
public class MeetingCtrl {

	@Autowired
	private MeetingService service;

	@CrossOrigin
	@RequestMapping(value="/meetings", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meetings/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meetings", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Meeting meeting) {
		return new ResponseEntity<>(service.create(meeting), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meetings/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody Meeting meeting, long id) {
		return new ResponseEntity<>(service.update(meeting, id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meetings/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meetings/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(String str) {
		return null;
	}

}
