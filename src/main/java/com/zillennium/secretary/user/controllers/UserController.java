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

import com.zillennium.secretary.user.models.User;
import com.zillennium.secretary.user.services.UserService.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@CrossOrigin
	@RequestMapping("/list")
	public ResponseEntity<Object> allUsers(){
		return new ResponseEntity<>(userService.all(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody User user){
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody User user, @PathVariable("id") long id){
		System.out.println("ID: " + id);
		System.out.println("Conrtroller: " + user.getRole());
		return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") long id) {
		return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/users/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(@RequestParam(value="search", required=false, defaultValue="") String search){
		//System.out.println(search);
		return new ResponseEntity<>(userService.search(search), HttpStatus.OK);
	}
	
}
