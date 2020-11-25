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

import com.zillennium.secretary.user.models.Organization;
import com.zillennium.secretary.user.services.OrganizationService.OrganizationService;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrganizationService orgService;
	
	@RequestMapping(value="/organizations", method=RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>(orgService.all(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/organizations/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(orgService.get(id), HttpStatus.OK);
	}

	@RequestMapping(value="/organizations", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Organization organization){
		return new ResponseEntity<>(orgService.create(organization), HttpStatus.OK);
	}
	
	@RequestMapping(value="/organizations/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody Organization organization, @PathVariable("id") long id) {
		return new ResponseEntity<>(orgService.update(organization, id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/organizations/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id){
		return new ResponseEntity<>(orgService.delete(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/organizations/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str) {
		return new ResponseEntity<>(orgService.search(str), HttpStatus.OK);
	}
	
}
