package com.exception.mvc.core;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 * 
 *         This is the abstract parent class for custom exceptions. The
 *         {@link Error} interface is used to access information about the error
 *         code and message specific to the scenario that had caused the
 *         {@link Exception} to be thrown. While the detailedDescription field
 *         contains the exact property/scenario details along with a possible
 *         explanation on how to fix the exception.
 *
 * @see GenericConnectorException
 * @see GenericServiceException
 * @see GenericControllerException
 */
public abstract class AbstractBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Error error;
	private String detailedDescription;

	/**
	 * @return the detailedDescription
	 */
	public String getDetailedDescription() {
		return detailedDescription;
	}

	/**
	 * @param detailedDescription
	 *            the detailedDescription to set
	 */
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractBaseException [error=" + error + ", detailedDescription=" + detailedDescription + "]";
	}

	public AbstractBaseException(AbstractBaseException abe) {

		this.error = abe.error;
		this.detailedDescription = abe.detailedDescription;

	}

	public AbstractBaseException(Error error) {

		this.error = error;

	}

	public AbstractBaseException(Error error, String detailedDescription) {

		this.error = error;
		this.detailedDescription = detailedDescription;

	}

}
