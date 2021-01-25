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

import com.zillennium.secretary.user.models.MeetingModels.ProjectType;
import com.zillennium.secretary.user.services.ProjectTypeService.ProjectTypeService;

@RestController
public class ProjectTypeCtrl {
	
	@Autowired
	private ProjectTypeService service;

	@RequestMapping(value="/project-types", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}

	@RequestMapping(value="/project-types/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@RequestMapping(value="/project-types", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody ProjectType projectType) {
		return new ResponseEntity<>(service.create(projectType), HttpStatus.OK);
	}

	@RequestMapping(value="/project-types/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ProjectType projectType, @PathVariable("id") long id) {
		return new ResponseEntity<>(service.update(projectType, id), HttpStatus.OK);
	}

	@RequestMapping(value="/project-types/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@RequestMapping(value="/project-type/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam String str) {
		return null;
	}	
	
}
