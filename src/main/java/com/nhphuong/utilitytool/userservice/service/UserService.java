package com.nhphuong.utilitytool.userservice.service;


import java.util.List;

import com.nhphuong.utilitytool.userservice.exception.EntityExistsException;
import com.nhphuong.utilitytool.userservice.exception.EntityNotFoundException;
import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;
import com.nhphuong.utilitytool.userservice.sdo.AddUserIn;
import com.nhphuong.utilitytool.userservice.sdo.AddUserOut;

public interface UserService {
	ApplicationUser getUser(String username) throws ValidationException, EntityNotFoundException;
	AddUserOut addUser(AddUserIn user) throws ValidationException, EntityExistsException;
	List<ApplicationRole> getUserRoles(String username) throws ValidationException, EntityNotFoundException;
}
