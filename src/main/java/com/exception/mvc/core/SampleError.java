package com.exception.mvc.core;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 *
 *         Sample Error class that has error codes specific to http status
 *         codes. The sample error class should have domain specific details.
 *         Use case specific details will be part
 *         of @AbstractBaseException.detailedMessage field
 *
 */
public enum SampleError implements Error {

	RESOURCE_NOT_FOUND(404, "Resource not found.Please pass correct resource identifier."),

	INTERNAL_SERVER_ERROR(500, "Internal Server Error occurred.");

	private final int code;
	private final String message;

	private SampleError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		return code + ": " + message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
