package com.nhphuong.utilitytool.userservice.sdo;

import java.io.Serializable;

public class AddUserOut implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4388162252294429147L;
	private Long userKey;

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

}
