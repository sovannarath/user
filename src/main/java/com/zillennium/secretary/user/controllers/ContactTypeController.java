package com.zillennium.secretary.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zillennium.secretary.user.models.ContactType;
import com.zillennium.secretary.user.services.ContactTypeService.ContactTypeService;

@Controller
public class ContactTypeController {
	
	@Autowired
	private ContactTypeService contactTypeService;
	
	@RequestMapping(value="/contact-types", method=RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>(contactTypeService.all(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-types/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(contactTypeService.get(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-types", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody ContactType type){
		return new ResponseEntity<>(contactTypeService.create(type), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-types/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ContactType type, @PathVariable("id") long id){
		return new ResponseEntity<>(contactTypeService.update(type, id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-types/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(contactTypeService.delete(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-types/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str) {
		return new ResponseEntity<>(contactTypeService.search(str), HttpStatus.OK);
	}
	
}
