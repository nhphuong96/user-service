package com.nhphuong.utilitytool.userservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseDAO {

	@Column(name = "created_date", insertable = false, updatable = false)
	@CreatedDate
	private Date createdDate;

	@Column(name = "last_modified_date", insertable = false, updatable = false)
	@LastModifiedDate
	private Date lastModifiedDate;

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
