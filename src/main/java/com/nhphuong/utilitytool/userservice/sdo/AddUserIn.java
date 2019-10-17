package com.nhphuong.utilitytool.userservice.sdo;

import java.io.Serializable;

import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;

public class AddUserIn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3698077106993077771L;
	private ApplicationUser user;
	private ApplicationRole[] roles;

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public ApplicationRole[] getRoles() {
		return roles;
	}

	public void setRoles(ApplicationRole[] roles) {
		this.roles = roles;
	}

}
