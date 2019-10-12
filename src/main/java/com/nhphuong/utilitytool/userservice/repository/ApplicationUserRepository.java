package com.nhphuong.utilitytool.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.nhphuong.utilitytool.userservice.model.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>{
	public ApplicationUser findByUsername(String username);
}
