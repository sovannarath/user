package com.zillennium.secretary.user.models.MeetingModels;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private String attachment_type;
	
	@ManyToOne
	@JoinColumn(name="agenda_id")
	private MeetingAgenda agenda;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;

	public MeetingAttachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingAttachment(long id, String attachment_path, String domain_name, MeetingAgenda agenda,
			String attachment_type, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.id = id;
		this.attachment_path = attachment_path;
		this.domain_name = domain_name;
		this.agenda = agenda;
		this.attachment_type = attachment_type;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAttachment_path() {
		return attachment_path;
	}

	public void setAttachment_path(String attachment_path) {
		this.attachment_path = attachment_path;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public MeetingAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(MeetingAgenda agenda) {
		this.agenda = agenda;
	}

	public String getAttachment_type() {
		return attachment_type;
	}

	public void setAttachment_type(String attachment_type) {
		this.attachment_type = attachment_type;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	
}
