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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.Organization;
import com.zillennium.secretary.user.models.User;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String purpose;
	private String description;
	private Date start_date;
	private Date end_date;
	private byte is_active = 1;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;
	
	@JsonIgnoreProperties({"users", "projects"})
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization", "meetings", "meeting_records", "projects", "meeting_actions", "meeting_participateds"}) 
	@ManyToOne
	@JoinColumn(name="manager_id")
	private User manager;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="project_type")
	private ProjectType type;

	public Project() {
		super();
	}

	public Project(long id, String name, String purpose, String description, Date start_date, Date end_date,
			byte is_active, Date created_at, Date updated_at, Date deleted_at, Organization organization,
			User manager) {
		super();
		this.id = id;
		this.name = name;
		this.purpose = purpose;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.is_active = is_active;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.organization = organization;
		this.manager = manager;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public byte getIs_active() {
		return is_active;
	}

	public void setIs_active(byte is_active) {
		this.is_active = is_active;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}
	
}
