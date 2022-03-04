/** CSCI 540: Assignment #4
 *  Programmer: Ben Corriette
 *  Last modified date: 03/04/2022
 */
package org.howard.edu.lsp.assignment5.test;
import org.howard.edu.lsp.assignment5.implementation.*;

/**
 * The implementation of the test class for the integer set implementation.
 * @author Ben Corriette
 */
public class Driver {

	/**
	 * The starting point of the program.
	 * 
	 * @param args Represents string arguments.
	 * @throws IntegerSetException If the set is empty when remove(), smallest(), or largest() is called.
	 */
	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		
		// Add to 10 integers to Set #1
		System.out.println("Adding integers 1 through 10 to Set 1...");
		System.out.println();
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(6);
		set1.add(7);
		set1.add(8);
		set1.add(9);
		set1.add(10);

		// To String, Smallest, and Largest of Set #1
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Smallest integer in Set 1: " + set1.smallest());
		System.out.println("Largest integer in Set 1: " + set1.largest());
		System.out.println();

		IntegerSet set2 = new IntegerSet();
		
		// Add to Set #2
		System.out.println("Adding integers 11 through 20 to Set 2...");
		System.out.println();
		
		set2.add(11);
		set2.add(12);
		set2.add(13);
		set2.add(14);
		set2.add(15);
		set2.add(16);
		set2.add(17);
		set2.add(18);
		set2.add(19);
		set2.add(20);
		
		// To String, Smallest, and Largest
		System.out.println("Value of Set 2: " + set2.toString());
		System.out.println("Smallest integer in Set 2: " + set2.smallest());
		System.out.println("Largest integer in Set 2: " + set2.largest());
		System.out.println();

		// Union
		System.out.println("Union of Sets 1 and 2...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Value of Set 2: " + set2.toString());
		set1.union(set2);
		System.out.println("Result of union of Set 1 and Set 2: " + set1.toString());
		System.out.println();
		
		// Intersection
		System.out.println("Intersect of Sets 1 and 2...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Value of Set 2: " + set2.toString());
		set1.intersect(set2);
		System.out.println("Result of intersect of Set 1 and Set 2: " + set1.toString());
		System.out.println();
		
		// Difference
		System.out.println("Difference of Sets 1 and 2...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Value of Set 2: " + set2.toString());
		set1.diff(set2);
		System.out.println("Result of difference of Set 1 and Set 2: " + set1.toString());
		System.out.println();
		
		// Equals
		System.out.println("Checking if Set 1 equals Set 2...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Value of Set 2: " + set2.toString());
		System.out.println("Does Set 1 equal Set 2? " + set1.equals(set2));
		System.out.println();
		
		// Length
		System.out.println("Checking the length of Set 1...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Set 1 contains this number of elements: " + set1.length());
		System.out.println("Checking the length of Set 2...");
		System.out.println("Value of Set 2: " + set2.toString());
		System.out.println("Set 2 contains this number of elements: " + set2.length());
		System.out.println();
		
		// Contains
		System.out.println("Checking if Set 1 contains certain elements...");
		System.out.println("Value of Set 1: " + set1.toString());
		System.out.println("Does Set 1 contain the integer 0? " + set1.contains(0));
		System.out.println("Does Set 1 contain the integer 5? " + set1.contains(5));
		System.out.println("Checking if Set 2 contains certain elements...");
		System.out.println("Value of Set 2: " + set2.toString());
		System.out.println("Does Set 2 contain the integer 11? " + set2.contains(11));
		System.out.println("Does Set 2 contain the integer 50? " + set2.contains(50));
		System.out.println();
		
		// Remove
		System.out.println("Removing the integers 13 and 17 from Set 2...");
		System.out.println("Value of Set 2 before remove operation: " + set2.toString());
		set2.remove(13);
		set2.remove(17);
		System.out.println("Value of Set 2 after remove operation: " + set2.toString());
		System.out.println();
		
		// Clear
		System.out.println("Clearing out all of the elements of Set 2...");
		System.out.println("Value of Set 2 before clear operation: " + set2.toString());
		set2.clear();
		System.out.println("Value of Set 2 after clear operation: " + set2.toString());
		System.out.println();
		
		// Is Empty
		System.out.println("Checking if Set 2 is empty...");
		System.out.println("Value of Set 2: " + set2.toString());
		System.out.println("Is Set 2 empty? " + set2.isEmpty());
		System.out.println();
		
		// Exit Message
		System.out.println("Exiting Integer Set test program...");
	}

}
