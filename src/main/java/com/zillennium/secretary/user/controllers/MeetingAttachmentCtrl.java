package com.zillennium.secretary.user.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zillennium.secretary.user.models.MeetingModels.MeetingAgenda;
import com.zillennium.secretary.user.models.MeetingModels.MeetingAttachment;
import com.zillennium.secretary.user.services.MeetingAttachmentService.MeetingAttachmentServiceImpl;
import com.zillennium.secretary.user.services.UploadService.FilesStorageService;

@Controller
public class MeetingAttachmentCtrl {
	
	@Autowired
	private MeetingAttachmentServiceImpl service;
	
	@Autowired
	FilesStorageService storageService;
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments", method=RequestMethod.GET)
	public ResponseEntity<Object> index() {
		return new ResponseEntity<>(service.all(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments", method=RequestMethod.POST)
	public ResponseEntity<Object> create(HttpServletRequest request, @PathVariable("agenda_id") long agenda_id, @RequestParam("file") MultipartFile file) {
		String message = "";
	    try {
	    	MeetingAttachment attach = new MeetingAttachment();
	    	MeetingAgenda agenda = new MeetingAgenda();
			storageService.save(file);
		    message = "Uploaded the file successfully: " + file.getOriginalFilename();
		    
		    String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
		            .replacePath(null)
		            .build()
		            .toUriString();
		    
		    agenda.setId(agenda_id);
		    attach.setAgenda(agenda);
		    attach.setDomain_name(baseUrl);
		    attach.setAttachment_path(file.getOriginalFilename());
		    attach.setAttachment_type("FILE");
		    
			return new ResponseEntity<>(service.create(attach), HttpStatus.OK);
		} catch (Exception e) {
			Map<String, String> map = new HashMap<String, String>();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			map.put("msg", message);
			map.put("status", "-1");
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody MeetingAttachment attach, long id) {
		return new ResponseEntity<>(service.update(attach, id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> destroy(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="meeting-agendas/{agenda_id}/attachments/search", method=RequestMethod.GET)
	public ResponseEntity<Object> search(String str) {
		return null;
	}
}
