package com.nhphuong.utilitytool.userservice.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;
import com.nhphuong.utilitytool.userservice.repository.ApplicationUserRepository;
import com.nhphuong.utilitytool.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ApplicationUserRepository applUserRepo;
	
	@Override
	public ApplicationUser getUser(String username) throws ValidationException {
		if (StringUtils.isBlank(username)) {
			throw new ValidationException("Username must not be null or empty.");
		}
		ApplicationUser user = applUserRepo.findByUsername(username);
		return user;
	}

}
