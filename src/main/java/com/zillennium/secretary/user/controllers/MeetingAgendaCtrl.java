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

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;
import com.zillennium.secretary.user.services.MeetingAgendaService.MeetingAgendaService;

@Controller
@CrossOrigin("http://localhost:8888")
public class MeetingAgendaCtrl {
	
	@Autowired
	private MeetingAgendaService service;
	
	@RequestMapping(value="/meeting-agendas", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-agendas/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-agendas", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody MeetingAgenda agenda) {
		return new ResponseEntity<>(service.create(agenda), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-agendas/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingAgenda agenda, long id) {
		return new ResponseEntity<>(service.update(agenda, id), HttpStatus.OK);
	}

	@RequestMapping(value="/meeting-agendas/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/meeting-agendas/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(String str) {
		return null;
	}
	
}
