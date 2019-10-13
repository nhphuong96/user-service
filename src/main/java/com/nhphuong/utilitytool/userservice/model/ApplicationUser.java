package com.nhphuong.utilitytool.userservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "application_user")
@JsonIgnoreProperties(value = { "roles" })
public class ApplicationUser extends BaseDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8701388594958862573L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appl_user_key", nullable = false)
	private Long userKey;

	@Column(name = "appl_user_id", nullable = false)
	private String userId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "is_locked")
	private int isLocked;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "application_user_role", joinColumns = @JoinColumn(name = "appl_user_key", referencedColumnName = "appl_user_key"), inverseJoinColumns = @JoinColumn(name = "appl_role_key", referencedColumnName = "appl_role_key"))
	private Set<ApplicationRole> roles;

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}

	public Set<ApplicationRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<ApplicationRole> roles) {
		this.roles = roles;
	}

}
