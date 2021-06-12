package com.zillennium.secretary.user.models.MeetingModels;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="meeting_agendas")
public class MeetingAgenda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String agenda_comment;
	
	@JsonIgnoreProperties({"project", "manager", "recorder", "checker", "actions", "agendas"})
	@ManyToOne
	@JoinColumn(name="meeting_id")
	private Meeting meeting;
	
	@JsonIgnoreProperties("agenda")
	@OneToMany(mappedBy="agenda")
	private List<MeetingAttachment> attachments;
	
	@JsonIgnoreProperties({"meeting"})
	@OneToMany(mappedBy="agenda")
	private List<MeetingAction> discussions;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;

	public MeetingAgenda(long id, String name, String description, String agenda_comment, Meeting meeting,
			List<MeetingAttachment> attachments, List<MeetingAction> discussions, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.agenda_comment = agenda_comment;
		this.meeting = meeting;
		this.attachments = attachments;
		this.discussions = discussions;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public MeetingAgenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<MeetingAction> getDiscussions() {
		return discussions;
	}
	
	public void setDiscussions(List<MeetingAction> discussions) {
		this.discussions = discussions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MeetingAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<MeetingAttachment> attachments) {
		this.attachments = attachments;
	}

	public String getAgenda_comment() {
		return agenda_comment;
	}

	public void setAgenda_comment(String agenda_comment) {
		this.agenda_comment = agenda_comment;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
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
