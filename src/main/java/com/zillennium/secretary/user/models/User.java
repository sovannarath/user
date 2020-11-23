package com.zillennium.secretary.user.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String email_verified_at;
	private String password;
	private String remember_token;
	private String created_at;
	private String updated_at;
	private String position;
	private String phone_number;
	private String date_of_birth;
	private String gender;
	private byte status;
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id")
	private UserRole role;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference", referencedColumnName = "id")
	@JsonBackReference
	private User reference;
	
	@OneToMany(mappedBy="reference")
	private List<User> children;
	
	@OneToMany(mappedBy="user")
	private List<UserContact> contacts;
	
	@ManyToOne
	@JoinColumn(name="organization_id", referencedColumnName="id")
	@JsonBackReference
	private Organization organization;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, String email, String email_verified_at, String password, String remember_token,
			String created_at, String updated_at, String position, String phone_number, String date_of_birth,
			String gender, byte status, UserRole role, User reference, List<User> children,
			List<UserContact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.remember_token = remember_token;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.position = position;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.status = status;
		this.role = role;
		this.reference = reference;
		this.children = children;
		this.contacts = contacts;
	}

	
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
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
	
}
