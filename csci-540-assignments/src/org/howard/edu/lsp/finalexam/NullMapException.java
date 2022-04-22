/** CSCI 540: Final Exam
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 04/22/2022
 *  Summary: A custom exception for null hash maps.
 *  
 *  References: org.howard.edu.lsp.assignment6.IntegerSetException 
 */
package org.howard.edu.lsp.finalexam;

/**
 * Custom exception class for null hash maps.
 * 
 * @author Ben Corriette
 *
 */
public class NullMapException extends Exception {
	/**
	 * The required serial version UID, which was generated.
	 */
	private static final long serialVersionUID = 6585988606273525868L;
	//private static final String message = "One or both maps are null!";

	/**
	 * Integer set exception implementation.
	 * 
	 * @param message Represents a message stating that one or both hash maps are null.
	 */
	public NullMapException(String message) {
		super(message);
	}
}
