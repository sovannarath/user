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

import com.zillennium.secretary.user.models.User;
import com.zillennium.secretary.user.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list")
	public ResponseEntity<Object> allUsers(){
		return new ResponseEntity<>(userService.all(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody User user){
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}
	
}
