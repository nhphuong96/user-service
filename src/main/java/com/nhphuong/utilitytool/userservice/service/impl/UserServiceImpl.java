package com.nhphuong.utilitytool.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhphuong.utilitytool.userservice.exception.EntityNotFoundException;
import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;
import com.nhphuong.utilitytool.userservice.repository.ApplicationRoleRepository;
import com.nhphuong.utilitytool.userservice.repository.ApplicationUserRepository;
import com.nhphuong.utilitytool.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ApplicationUserRepository applUserRepo;
	
	@Autowired
	private ApplicationRoleRepository applRoleRepo;
	
	@Override
	public ApplicationUser getUser(String username) throws ValidationException, EntityNotFoundException {
		if (StringUtils.isBlank(username)) {
			throw new ValidationException("Username must not be null or empty.");
		}
		ApplicationUser user = applUserRepo.findByUsername(username);
		if (user == null) {
			throw new EntityNotFoundException("User not found.");
		}
		return user;
	}

	@Override
	public List<ApplicationRole> getUserRoles(String username) throws ValidationException, EntityNotFoundException {
		if (StringUtils.isBlank(username)) {
			throw new ValidationException("Username must not be null or empty.");
		}
		List<ApplicationRole> roles = applRoleRepo.findByUsers_Username(username);
		return new ArrayList<>(roles);
	}

}
