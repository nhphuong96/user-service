package com.nhphuong.utilitytool.userservice.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

	@Column(name = "created_date")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "created_by")
	@CreatedBy
	private U createdBy;

	@Column(name = "last_modified_date")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "last_modified_by")
	@LastModifiedBy
	private U lastModifiedBy;

	@Column(name = "is_deleted")
	private int isDeleted;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

}
