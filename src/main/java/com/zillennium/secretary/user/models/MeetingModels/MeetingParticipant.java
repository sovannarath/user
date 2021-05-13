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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.User;

@Entity
@Table(name="meeting_participants")
public class MeetingParticipant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization", "meetings", "meeting_records", "projects", "meeting_actions", "meeting_participateds"})
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@JsonIgnoreProperties({"recorder", "manager", "project", "overview", "problem", "opportunity", "objective", "discussion", "comment", "conclusion"})
	@ManyToOne
	@JoinColumn(name="meeting_id")
	private Meeting meeting;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleted_at;

	public MeetingParticipant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingParticipant(long id, User user, Meeting meeting, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.id = id;
		this.user = user;
		this.meeting = meeting;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
