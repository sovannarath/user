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
import org.springframework.web.bind.annotation.RequestParam;

import com.zillennium.secretary.user.models.UserContact;
import com.zillennium.secretary.user.services.UserContactService.UserContactService;

@Controller
public class UserContactController {
	
	@Autowired
	private UserContactService userContactService;
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts", method=RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>(userContactService.all(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(userContactService.get(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody UserContact contact){
		return new ResponseEntity<>(userContactService.create(contact), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody UserContact contact, @PathVariable("id") long id){
		return new ResponseEntity<>(userContactService.update(contact, id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id){
		return new ResponseEntity<>(userContactService.delete(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/user-contacts/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str){
		return new ResponseEntity<>(userContactService.search(str), HttpStatus.OK);
	}

}
