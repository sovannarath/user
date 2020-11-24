package com.zillennium.secretary.user.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_contact")
public class UserContact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name="type_id", referencedColumnName="id")
	private ContactType type;
	
	@ManyToOne
	@JoinColumn(name="provider_id", referencedColumnName="id")
	private ContactProvider provider;
	
	private String contact;
	private byte is_active;
	private byte is_default;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	public UserContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserContact(long id, User user, ContactType type, ContactProvider provider, String contact, byte is_active,
			byte is_default, String created_at, String updated_at, String deleted_at) {
		super();
		this.id = id;
		this.user = user;
		this.type = type;
		this.provider = provider;
		this.contact = contact;
		this.is_active = is_active;
		this.is_default = is_default;
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
	public ContactType getType() {
		return type;
	}
	public void setType(ContactType type) {
		this.type = type;
	}
	public ContactProvider getProvider() {
		return provider;
	}
	public void setProvider(ContactProvider provider) {
		this.provider = provider;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public byte getIs_active() {
		return is_active;
	}
	public void setIs_active(byte is_active) {
		this.is_active = is_active;
	}
	public byte getIs_default() {
		return is_default;
	}
	public void setIs_default(byte is_default) {
		this.is_default = is_default;
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
