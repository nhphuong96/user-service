package com.nhphuong.utilitytool.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhphuong.utilitytool.userservice.exception.EntityNotFoundException;
import com.nhphuong.utilitytool.userservice.exception.ValidationException;
import com.nhphuong.utilitytool.userservice.model.ApplicationRole;
import com.nhphuong.utilitytool.userservice.model.ApplicationUser;
import com.nhphuong.utilitytool.userservice.model.ResponseWrapper;
import com.nhphuong.utilitytool.userservice.service.UserService;

@RestController
@RequestMapping("api/user")
public class ApplicationUserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getUser")
	public ResponseWrapper<ApplicationUser> getUserDetail(@RequestParam(name="username") String username) {
		try {
			ApplicationUser user = userService.getUser(username);
			return new ResponseWrapper<ApplicationUser>(user, username, true);
		} catch (ValidationException | EntityNotFoundException e) {
			return new ResponseWrapper<>(null, e.getMessage(), false);
		}
	}
	
	@GetMapping(value= "/getRoles")
	public ResponseWrapper<List<ApplicationRole>> getUserRoles(@RequestParam(name="username") String username) {
		try {
			List<ApplicationRole> userRoles = userService.getUserRoles(username);
			return new ResponseWrapper<List<ApplicationRole>>(userRoles, "success", true);
		} catch (ValidationException | EntityNotFoundException e) {
			return new ResponseWrapper<>(null, e.getMessage(), false);
		}
	}
	
}
