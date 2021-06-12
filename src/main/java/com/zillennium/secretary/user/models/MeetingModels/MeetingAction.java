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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.User;

@Entity
@Table(name="meeting_discussion_logs")
public class MeetingAction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	//@JsonIgnore
	@JsonIgnoreProperties({"project", "manager", "recorder", "checker", "actions"})
	@ManyToOne
	@JoinColumn(name="meeting_id")
	private Meeting meeting;
	
	//@JsonIgnore
	@JsonIgnoreProperties({"attachments", "meeting", "discussions"})
	@ManyToOne
	@JoinColumn(name="agenda_id")
	private MeetingAgenda agenda;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization", "meetings", "meeting_records", "projects", "meeting_actions", "meeting_participateds", "role", "groups", })
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="action_id")
	private MeetingActionType action_type;
	
	@JsonIgnoreProperties({"action_type", "user", "agenda", "meeting"})
	@OneToOne
	@JoinColumn(name="related_action", referencedColumnName="id")
	private MeetingAction related_action;
	
	/*@JsonIgnore
	@OneToOne(mappedBy="related_action")
	private MeetingAction action;*/
	
	public MeetingAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(MeetingAgenda agenda) {
		this.agenda = agenda;
	}

	public MeetingAction getRelated_action() {
		return related_action;
	}

	public void setRelated_action(MeetingAction related_action) {
		this.related_action = related_action;
	}

	/*public MeetingAction getAction() {
		return action;
	}

	public void setAction(MeetingAction action) {
		this.action = action;
	}*/

	private String description;
	private String note;
	private byte is_active = 1;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	private Date deleted_at;

	public MeetingAction() {
		super();
	}

	public MeetingAction(long id, Meeting meeting, User user, MeetingActionType action_type, String description,
			String note, byte is_active, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.id = id;
		this.meeting = meeting;
		this.user = user;
		this.action_type = action_type;
		this.description = description;
		this.note = note;
		this.is_active = is_active;
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

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MeetingActionType getAction_type() {
		return action_type;
	}

	public void setAction_type(MeetingActionType action_type) {
		this.action_type = action_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	
}
