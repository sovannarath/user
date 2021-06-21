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
@Table(name="meeting_group_users")
public class MeetingGroupParticipant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="meeting_group_id")
	private MeetingParticipantGroup pGroup;
	
	@JsonIgnoreProperties({"reference", "children", "meetings", "meeting_records", "meeting_actions", "meeting_participateds", "projects", "groups"/*, "contacts", "organization"*/})
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MeetingParticipantGroup getpGroup() {
		return pGroup;
	}

	public void setpGroup(MeetingParticipantGroup pGroup) {
		this.pGroup = pGroup;
	}

	public MeetingGroupParticipant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingGroupParticipant(long id, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.id = id;
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
