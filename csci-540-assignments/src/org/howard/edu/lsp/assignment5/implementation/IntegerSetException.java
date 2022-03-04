/**
 * 
 */
package org.howard.edu.lsp.assignment5.implementation;

/**
 * Custom exception class for integer set implementation.
 * 
 * @author Ben Corriette
 *
 */
public class IntegerSetException extends Exception {
	
	/**
	 * The required serial version UID, which was generated.
	 */
	private static final long serialVersionUID = 6585988606273525868L;
	private static final String message = "The set is empty";

	/**
	 * Integer set exception implementation.
	 */
	public IntegerSetException() {
		super(message);
	}
}
