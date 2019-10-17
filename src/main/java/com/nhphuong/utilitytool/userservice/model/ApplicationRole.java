package com.nhphuong.utilitytool.userservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "application_role")
public class ApplicationRole extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 1792728487354177830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appl_role_key")
	private Long roleKey;

	@Column(name = "appl_role_id")
	private String roleId;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<ApplicationUser> users;

	public Long getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(Long roleKey) {
		this.roleKey = roleKey;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
