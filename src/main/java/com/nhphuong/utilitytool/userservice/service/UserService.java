package com.nhphuong.utilitytool.userservice.service;


import java.util.List;

import com.nhphuong.utilitytool.userservice.exception.EntityNotFoundException;
import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;

public interface UserService {
	ApplicationUser getUser(String username) throws ValidationException, EntityNotFoundException;
	List<ApplicationRole> getUserRoles(String username) throws ValidationException, EntityNotFoundException;
}
