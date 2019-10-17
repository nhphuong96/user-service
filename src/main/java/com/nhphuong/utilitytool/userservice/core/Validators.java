package com.nhphuong.utilitytool.userservice.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.nhphuong.utilitytool.userservice.exception.ValidationException;

public final class Validators {
	private Validators() {

	}

	public static void validateNotNull(Object o, String objName) throws ValidationException {
		String defaultFieldName = "object";
		if (StringUtils.isNotEmpty(objName)) {
			defaultFieldName = objName;
		}

		if (o == null) {
			throw new ValidationException(defaultFieldName + " must not be null.");
		}
	}

	public static void validateNotEmpty(String o, String objName) throws ValidationException {
		String defaultFieldName = "object";
		if (StringUtils.isNotEmpty(objName)) {
			defaultFieldName = objName;
		}

		if (StringUtils.isBlank(o)) {
			throw new ValidationException(defaultFieldName + " must not be null or empty.");
		}
	}

	public static void validateNotEmpty(List<?> o, String objName) throws ValidationException {
		String defaultFieldName = "object";
		if (StringUtils.isNotEmpty(objName)) {
			defaultFieldName = objName;
		}

		if (CollectionUtils.isEmpty(o)) {
			throw new ValidationException(defaultFieldName + " must not be null or empty.");
		}
	}
}
