package com.zillennium.secretary.user.models.MeetingModels;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.User;

@Entity
@Table(name="meeting_participant_groups")
public class MeetingParticipantGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	
	@JsonIgnoreProperties({"pGroup"})
	@OneToMany(mappedBy = "pGroup")
	private List<MeetingGroupParticipant> participant;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;

	public MeetingParticipantGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public List<MeetingGroupParticipant> getParticipant() {
		return participant;
	}



	public void setParticipant(List<MeetingGroupParticipant> participant) {
		this.participant = participant;
	}



	public MeetingParticipantGroup(long id, String name, String description, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
