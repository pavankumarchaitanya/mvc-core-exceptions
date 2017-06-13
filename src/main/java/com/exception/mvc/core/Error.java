package com.exception.mvc.core;

/**
 * 
 * @author PChaita1
 * 
 *         This interface is commonly used in domain specific
 *         {@link Exception} classes and is a member variable of
 *         {@link AbstractBaseException} class.
 * 
 *         {@link SampleError} enum implements the {@link Error} interface.
 * 
 * 
 * 
 * @see SampleError
 */
public interface Error {

	public int getCode();

	public String getMessage();

}
