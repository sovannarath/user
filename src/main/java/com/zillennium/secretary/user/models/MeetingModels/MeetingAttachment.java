package com.zillennium.secretary.user.models.MeetingModels;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="meeting_attachments")
public class MeetingAttachment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String attachment_path;
	private String domain_name;
	private MeetingAgenda agenda;
	private String attachment_type;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;
}
