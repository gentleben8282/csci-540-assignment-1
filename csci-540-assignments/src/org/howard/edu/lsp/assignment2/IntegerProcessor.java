/** CSCI 540: Assignment #2
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 02/09/2022
 * 
 *  Summary: A simple program that processes integer input and then outputs the integers, along with
 *  the sum and product of those integers.
 *  
 *  References: https://www.javatpoint.com/how-to-take-string-input-in-java
 *  			https://stackoverflow.com/questions/22452930/terminating-a-java-program
 *  			https://www.geeksforgeeks.org/scanner-nextint-method-in-java-with-examples/
 *  		    https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
 *  			https://stackoverflow.com/questions/14721397/checking-if-a-string-is-empty-or-null-in-java
 *  			https://www.javatpoint.com/Scanner-class
 *  			https://www.geeksforgeeks.org/difference-between-and-equals-method-in-java/
 *  			https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
 */

package org.howard.edu.lsp.assignment2;
import java.util.*;

/**
 * Processes integers from the input stream by displaying them on the console, along with their
 * calculated sum and product.
 * 
 * @author Ben Corriette
 *
 */
public class IntegerProcessor {
	static Scanner scanInput = new Scanner(System.in);
	static Scanner scanString = null;
	static String userInput = "";
	
	private static Scanner getUserInput() {
		userInput = scanInput.nextLine();
		scanString = new Scanner(userInput);
		return scanString;
	}
	
	/**
	 * Exits the program.
	 * 
	 * @return Nothing
	 */
	private static void exitProgram() {
		// Clean up system resources
		scanInput.close();
		scanString.close();
		// Exit the program
		System.exit(0);
	}
	
	/**
	 * Processes the user input by parsing for integer tokens and outputs each token along with
	 * the sum and product of those integers.
	 * 
	 * @param sc Represents the Scanner object
	 * @return Nothing
	 */
	private static void processUserInput(Scanner sc) {
		System.out.println("Tokens:");
		int nextToken = 0;
		int sumOfTokens = 0;
		int productOfTokens = 1;
		// Step 2a: Process the user input string
		while (sc.hasNextInt()) {
			// Step 2b: Output the numbers
			nextToken = sc.nextInt();
			System.out.println(nextToken);
			sumOfTokens += nextToken;
			productOfTokens *= nextToken;
		}
		// Step 2c: Output the sum and product
		System.out.println("Sum: " + sumOfTokens);
		System.out.println("Product: " + productOfTokens);
		System.out.println();
	}

	/**
	 * The main method of the program.
	 * 
	 * @param args Represents any string arguments that are passed to the program
	 * @throws Exception if an exception occurs
	 * @return Nothing
	 */
	public static void main(String[] args) {
		try {
			while (true) {
				// Prompt the user for input
				System.out.println("String?");
			
				// Step 1: Read user input
				Scanner scanner = getUserInput();
					
				// Step 1a: Check for the string 'Goodbye'
				if (userInput.equals("Goodbye")) {
					exitProgram();
				} else if (!userInput.isBlank()) {
					// Step 2: Process the user input
					processUserInput(scanner);
				}
			}	
			
		} catch (Exception e) {
			System.out.println("An error has occurred: " +  e);
		}
	}
}
