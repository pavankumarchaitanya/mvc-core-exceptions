package com.exception.mvc.core;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author pavan.kumar.chaitanya@gmail.com
 * 
 *         The {@link GenericControllerExceptionHandler} handles exceptions
 *         thrown in the controller layer. It catches the
 *         {@link GenericControllerException} exception and
 *
 */
@ControllerAdvice
public class GenericControllerExceptionHandler {
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(GenericControllerExceptionHandler.class);

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleThrowableException(final Throwable ex,
			final HttpServletResponse response) {
		logger.error("inside handleThrowableException : {} ", ex);

		ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(
				new ErrorResponse(SampleError.INTERNAL_SERVER_ERROR),
				HttpStatus.valueOf(SampleError.INTERNAL_SERVER_ERROR.getCode()));
		return responseEntity;
	}

	@ExceptionHandler(GenericControllerException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleControllerException(final GenericControllerException ex,
			final HttpServletResponse response) throws IOException {
		logger.error("inside handleControllerException : {} ", ex);
		ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(new ErrorResponse(ex),
				HttpStatus.valueOf(ex.getError().getCode()));
		return responseEntity;
	}

	private class ErrorResponse {

		private final int code;
		private final String message;
		private final String detailedDescription;

		public ErrorResponse(int code, String message, String detailedDescription) {
			this.code = code;
			this.message = message;
			this.detailedDescription = detailedDescription;
		}

		public ErrorResponse(AbstractBaseException abstractBaseException) {
			this.code = abstractBaseException.getError().getCode();
			this.message = abstractBaseException.getError().getMessage();
			this.detailedDescription = abstractBaseException.getDetailedDescription();
		}

		public ErrorResponse(Error error) {
			this.code = error.getCode();
			this.message = error.getMessage();
			this.detailedDescription = null;
		}

		@Override
		public String toString() {
			return "ErrorResponse [code=" + code + ", message=" + message + ", detailedDescription="
					+ detailedDescription + "]";
		}

		/**
		 * @return the code
		 */
		public int getCode() {
			return code;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @return the detailedDescription
		 */
		public String getDetailedDescription() {
			return detailedDescription;
		}
	}
}
