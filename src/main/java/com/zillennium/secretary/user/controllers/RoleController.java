package com.zillennium.secretary.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zillennium.secretary.user.models.UserRole;

import com.zillennium.secretary.user.services.RoleService.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/roles", method=RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<>(roleService.all(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody UserRole role) {
		return new ResponseEntity<>(roleService.create(role), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody UserRole role, @PathVariable("id") long id) {
		return new ResponseEntity<>(roleService.update(role, id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(roleService.delete(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/search}", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam("search") String str){
		return new ResponseEntity<>(roleService.search(str), HttpStatus.OK);
	}
	
}