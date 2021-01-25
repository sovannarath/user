package com.zillennium.secretary.user.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="contact_types")
public class ContactType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private byte is_active;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	@JsonIgnore
	@OneToMany(mappedBy="type")
	private List<UserContact> contacts;
	
	public ContactType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactType(long id, String name, String description, byte is_active, String created_at, String updated_at,
			String deleted_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.is_active = is_active;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	
	public List<UserContact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<UserContact> contacts) {
		this.contacts = contacts;
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
	public byte getIs_active() {
		return is_active;
	}
	public void setIs_active(byte is_active) {
		this.is_active = is_active;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
}
