package com.zillennium.secretary.user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ControllerInterface {
	public ResponseEntity<Object> index();
	public ResponseEntity<Object> get(long id);
	public ResponseEntity<Object> create(Object object);
	public ResponseEntity<Object> update(Object object,long id);
	public ResponseEntity<Object> destroy(long id);
	public ResponseEntity<Object> search(String str);
}
