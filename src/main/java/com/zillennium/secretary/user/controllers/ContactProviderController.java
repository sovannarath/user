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

import com.zillennium.secretary.user.models.ContactProvider;
import com.zillennium.secretary.user.services.ContactProviderService.ContactProviderService;

@Controller
public class ContactProviderController {

	@Autowired
	private ContactProviderService contactProviderService;
	
	@RequestMapping(value="/contact-providers", method=RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>(contactProviderService.all(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-providers/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(contactProviderService.get(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-providers", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody ContactProvider provider) {
		return new ResponseEntity<>(contactProviderService.create(provider), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-providers/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ContactProvider provider, @PathVariable("id") long id) {
		return new ResponseEntity<>(contactProviderService.update(provider, id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-providers/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(contactProviderService.delete(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact-providers/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str) {
		return new ResponseEntity<>(contactProviderService.search(str), HttpStatus.OK);
	}
	
}
