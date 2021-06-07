package com.zillennium.secretary.user.models.MeetingModels;

import java.sql.Time;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zillennium.secretary.user.models.User;

@Entity
@Table(name="meetings")
public class Meeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private int issue_number;
	private Date date;
	private Time start_time;
	private Time end_time;
	private String location;
	//private String overview;
	private String objective;
	//private String problem;
	//private String opportunity;
	//private String discussion;
	private String conclusion;
	private String comment;
	private String status;
	private Date next_schedule;
	private String next_schedule_topic;
	private String next_schedule_comment;
	
	@JsonIgnoreProperties({"organization", "manager"})
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization", "meetings", "meeting_records", "projects", "meeting_actions", "meeting_participateds"})
	@ManyToOne
	@JoinColumn(name="recorder_id")
	private User recorder;
	
	private Date record_date;
	
	@JsonIgnoreProperties({"reference", "children", "contacts", "organization", "meetings", "meeting_records", "projects", "meeting_actions", "meeting_participateds"})
	@ManyToOne
	@JoinColumn(name="checker_id")
	private User checker;
	
	private Date check_date;
	private byte is_active;
	
	@OneToMany(mappedBy="meeting")
	private List<MeetingAction> actions;
	
	@JsonIgnoreProperties("meeting")
	@OneToMany(mappedBy="meeting")
	private List<MeetingAgenda> agendas;
	
	public List<MeetingAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<MeetingAgenda> agendas) {
		this.agendas = agendas;
	}

	@ManyToOne
	@JoinColumn(name="meeting_type")
	private MeetingType type;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleted_at;

	public Meeting() {
		super();
	}

	public Meeting(long id, String name, Project project, int issue_number, Date date, Time start_time, Time end_time,
			String location, String overview, String objective,
			String conclusion, String comment, String status, Date next_schedule, String next_schedule_topic,
			String next_schedule_comment, User recorder, Date record_date, User checker, Date check_date,
			byte is_active, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.issue_number = issue_number;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.location = location;
		this.objective = objective;
		this.conclusion = conclusion;
		this.comment = comment;
		this.status = status;
		this.next_schedule = next_schedule;
		this.next_schedule_topic = next_schedule_topic;
		this.next_schedule_comment = next_schedule_comment;
		this.recorder = recorder;
		this.record_date = record_date;
		this.checker = checker;
		this.check_date = check_date;
		this.is_active = is_active;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public List<MeetingAction> getActions() {
		return actions;
	}

	public void setActions(List<MeetingAction> actions) {
		this.actions = actions;
	}

	public MeetingType getType() {
		return type;
	}

	public void setType(MeetingType type) {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getIssue_number() {
		return issue_number;
	}

	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getNext_schedule() {
		return next_schedule;
	}

	public void setNext_schedule(Date next_schedule) {
		this.next_schedule = next_schedule;
	}

	public String getNext_schedule_topic() {
		return next_schedule_topic;
	}

	public void setNext_schedule_topic(String next_schedule_topic) {
		this.next_schedule_topic = next_schedule_topic;
	}

	public String getNext_schedule_comment() {
		return next_schedule_comment;
	}

	public void setNext_schedule_comment(String next_schedule_comment) {
		this.next_schedule_comment = next_schedule_comment;
	}

	public User getRecorder() {
		return recorder;
	}

	public void setRecorder(User recorder) {
		this.recorder = recorder;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

	public User getChecker() {
		return checker;
	}

	public void setChecker(User checker) {
		this.checker = checker;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
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
