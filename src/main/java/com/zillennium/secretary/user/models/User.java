package com.zillennium.secretary.user.models;

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
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.MeetingModels.Meeting;
import com.zillennium.secretary.user.models.MeetingModels.MeetingAction;
import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipant;
import com.zillennium.secretary.user.models.MeetingModels.MeetingParticipantGroup;
import com.zillennium.secretary.user.models.MeetingModels.Project;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String gender;
	private String date_of_birth;
	private String email;
	private String password;
	private String remember_token;
	private String api_token;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@JsonIgnoreProperties("users") 
	@ManyToOne
	@JoinColumn(name="role_id")
	private UserRole role;
	
	@JsonIgnoreProperties({"reference", "children", "contacts"}) 
	@ManyToOne
    @JoinColumn(name = "reference")
	private User reference;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization"}) 
	@OneToMany(mappedBy="reference")
	private List<User> children;
	
	@JsonIgnoreProperties({"user"})
	@OneToMany(mappedBy="user")
	private List<UserContact> contacts;
	
	@JsonIgnoreProperties("users")
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@OneToMany(mappedBy="checker")
	private List<Meeting> meetings;
	
	@OneToMany(mappedBy="recorder")
	private List<Meeting> meeting_records;
	
	@OneToMany(mappedBy="user")
	private List<MeetingAction> meeting_actions;
	
	@OneToMany(mappedBy="user")
	private List<MeetingParticipant> meeting_participateds;
	
	@OneToMany(mappedBy="manager")
	private List<Project> projects;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, String gender, String date_of_birth, String email, String password,
			String remember_token, String api_token, Date created_at, Date updated_at, UserRole role, User reference,
			List<User> children, List<UserContact> contacts, Organization organization, List<Meeting> meetings,
			List<Meeting> meeting_records, List<MeetingAction> meeting_actions,
			List<MeetingParticipant> meeting_participateds, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.password = password;
		this.remember_token = remember_token;
		this.api_token = api_token;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.role = role;
		this.reference = reference;
		this.children = children;
		this.contacts = contacts;
		this.organization = organization;
		this.meetings = meetings;
		this.meeting_records = meeting_records;
		this.meeting_actions = meeting_actions;
		this.meeting_participateds = meeting_participateds;
		this.projects = projects;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember_token() {
		return remember_token;
	}

	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}

	public String getApi_token() {
		return api_token;
	}

	public void setApi_token(String api_token) {
		this.api_token = api_token;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public User getReference() {
		return reference;
	}

	public void setReference(User reference) {
		this.reference = reference;
	}

	public List<User> getChildren() {
		return children;
	}

	public void setChildren(List<User> children) {
		this.children = children;
	}

	public List<UserContact> getContacts() {
		return contacts;
	}

	public void setContacts(List<UserContact> contacts) {
		this.contacts = contacts;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<Meeting> getMeeting_records() {
		return meeting_records;
	}

	public void setMeeting_records(List<Meeting> meeting_records) {
		this.meeting_records = meeting_records;
	}

	public List<MeetingAction> getMeeting_actions() {
		return meeting_actions;
	}

	public void setMeeting_actions(List<MeetingAction> meeting_actions) {
		this.meeting_actions = meeting_actions;
	}

	public List<MeetingParticipant> getMeeting_participateds() {
		return meeting_participateds;
	}

	public void setMeeting_participateds(List<MeetingParticipant> meeting_participateds) {
		this.meeting_participateds = meeting_participateds;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
}
