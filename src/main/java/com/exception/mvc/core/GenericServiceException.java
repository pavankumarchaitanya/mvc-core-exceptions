package com.exception.mvc.core;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 * 
 *         {@link GenericServiceException} class is thrown by the connector
 *         layer and is usually wrapped in {@link GenericControllerException} or
 *         handled in the controller layer of the application.
 */
public class GenericServiceException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public GenericServiceException(AbstractBaseException abe) {
		super(abe);
	}

	public GenericServiceException(Error error) {
		super(error);
	}

	public GenericServiceException(Error error, String detailedDescription) {
		super(error, detailedDescription);
	}

	@Override
	public String toString() {
		return "GenericServiceException :" + super.toString();
	}
}
