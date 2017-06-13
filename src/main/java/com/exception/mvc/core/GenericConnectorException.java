package com.exception.mvc.core;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 * 
 *         {@link GenericConnectorException} class is thrown by the connector
 *         layer and is usually wrapped in {@link GenericServiceException} or
 *         handled in the service layer of the application.
 *
 */
public class GenericConnectorException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public GenericConnectorException(AbstractBaseException abe) {
		super(abe);
	}

	public GenericConnectorException(Error error) {
		super(error);
	}

	public GenericConnectorException(Error error, String detailedDescription) {
		super(error, detailedDescription);
	}

	@Override
	public String toString() {
		return "GenericConnectorException :" + super.toString();
	}
}
