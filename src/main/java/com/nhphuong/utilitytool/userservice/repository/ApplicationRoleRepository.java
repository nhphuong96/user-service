package com.nhphuong.utilitytool.userservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nhphuong.utilitytool.userservice.model.ApplicationRole;

public interface ApplicationRoleRepository extends CrudRepository<ApplicationRole, Long>{

	public List<ApplicationRole> findByUsers_Username(String username);
}
