package com.zillennium.secretary.user.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String address;
	private String telephone;
	private String email;
	private byte is_active;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	@OneToMany(mappedBy="organization")
	private List<User> users;

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(long id, String name, String description, String address, String telephone, String email,
			byte is_active, String created_at, String updated_at, String deleted_at, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.is_active = is_active;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.users = users;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
