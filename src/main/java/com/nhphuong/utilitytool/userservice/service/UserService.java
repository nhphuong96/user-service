package com.nhphuong.utilitytool.userservice.service;

import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;

public interface UserService {
	ApplicationUser getUser(String username) throws ValidationException;
}
