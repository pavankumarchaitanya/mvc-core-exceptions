package com.exception.mvc.core;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 *
 *         {@link GenericControllerException} is thrown my the Controller layer of
 *         the application. It needs to be handled by the Exception handler
 *         which is usually annotated with the {@link ControllerAdvice}
 *         annotation.
 */
public class GenericControllerException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public GenericControllerException(AbstractBaseException abe) {
		super(abe);
	}

	public GenericControllerException(Error error) {
		super(error);
	}

	public GenericControllerException(Error error, String detailedDescription) {
		super(error, detailedDescription);
	}

	@Override
	public String toString() {
		return "GenericControllerException :" + super.toString();
	}
}
