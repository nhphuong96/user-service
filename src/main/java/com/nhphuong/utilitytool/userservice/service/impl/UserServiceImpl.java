package com.nhphuong.utilitytool.userservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhphuong.utilitytool.userservice.core.Validators;
import com.nhphuong.utilitytool.userservice.exception.EntityExistsException;
import com.nhphuong.utilitytool.userservice.exception.EntityNotFoundException;
import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;
import com.nhphuong.utilitytool.userservice.repository.ApplicationRoleRepository;
import com.nhphuong.utilitytool.userservice.repository.ApplicationUserRepository;
import com.nhphuong.utilitytool.userservice.sdo.AddUserIn;
import com.nhphuong.utilitytool.userservice.sdo.AddUserOut;
import com.nhphuong.utilitytool.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ApplicationUserRepository applUserRepo;
	
	@Autowired
	private ApplicationRoleRepository applRoleRepo;
	
	@Override
	public ApplicationUser getUser(String username) throws ValidationException, EntityNotFoundException {
		Validators.validateNotEmpty(username, "Username");
		ApplicationUser user = applUserRepo.findByUsername(username);
		if (user == null) {
			throw new EntityNotFoundException("User not found.");
		}
		return user;
	}

	@Override
	public List<ApplicationRole> getUserRoles(String username) throws ValidationException, EntityNotFoundException {
		Validators.validateNotEmpty(username, "Username");
		List<ApplicationRole> roles = applRoleRepo.findByUsers_Username(username);
		return new ArrayList<>(roles);
	}

	@Override
	public AddUserOut addUser(AddUserIn addUserIn) throws ValidationException, EntityExistsException {
		Validators.validateNotNull(addUserIn, "AddUserIn");
		Validators.validateNotNull(addUserIn.getUser(), "User");
		Validators.validateNotNull(addUserIn.getRoles(), "Roles");
		Validators.validateNotEmpty(addUserIn.getUser().getUsername(), "Username");
		Validators.validateNotEmpty(addUserIn.getUser().getPassword(), "Password");
		
		ApplicationUser user = addUserIn.getUser();
		if (applUserRepo.existsByUsername(user.getUsername())) {
			throw new EntityExistsException(user.getUsername() + " is existing.");
		}
		
		List<ApplicationRole> roles = Arrays.asList(addUserIn.getRoles());
		Validators.validateNotEmpty(roles, "User roles");

		if (StringUtils.isEmpty(user.getUserId())) {
			user.setUserId(user.getUsername());
		}
		user.setIsDeleted(0);
		user.setIsLocked(0);
		user.setRoles(resolveRoles(roles));
		
		applUserRepo.save(user);
		
		AddUserOut out = new AddUserOut();
		out.setUserKey(user.getUserKey());
		return out;
	}

	private Set<ApplicationRole> resolveRoles(List<ApplicationRole> roles) {
		Set<ApplicationRole> result = new HashSet<ApplicationRole>();
		for (ApplicationRole applicationRole : roles) {
			ApplicationRole role = applRoleRepo.findByRoleId(applicationRole.getRoleId());
			result.add(role);
		}
		return result;
	}

}
