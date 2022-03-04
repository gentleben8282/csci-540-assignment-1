/** CSCI 540: Assignment #4
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 03/04/2022
 *  Summary: An implementation of an integer set class.
 *  
 *  References: https://www.geeksforgeeks.org/difference-between-list-and-arraylist-in-java/
 *  			https://www.geeksforgeeks.org/constructors-in-java/
 *  			https://www.geeksforgeeks.org/user-defined-custom-exception-in-java/
 *  			https://www.geeksforgeeks.org/java-program-for-program-to-find-largest-element-in-an-array/
 *  			https://www.geeksforgeeks.org/difference-between-an-integer-and-int-in-java/
 *  			https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html/
 *  			https://stackoverflow.com/questions/31394715/how-to-convert-integer-to-int-array-in-java/
 *  			https://stackoverflow.com/questions/4468669/how-to-generate-javadoc-html-files-in-eclipse/
 */
package org.howard.edu.lsp.assignment5.implementation;
import java.util.*;

/**
 * An implementation of an integer set.
 * 
 * @author Ben Corriette
 */
public class IntegerSet {

	private List<Integer> integerSet = new ArrayList<Integer>();
	
	/**
	 * Returns the instance of the integer set.
	 * 
	 * @return The instance of the integer set.
	 */
	public List<Integer> getIntegerSet() {
		return integerSet;
	}
	
	/**
	 * Clears the internal representation of the set.
	 * 
	 */
	public void clear() {
		integerSet.clear();
	}

	/**
	 * Returns the length of the set.
	 * 
	 * @return The length of the set.
	 */
	public int length() {
		return integerSet.size();
	}

	/**
	 * Two sets are equal if they contain all of the same values in any order.
	 * 
	 * @param setToCompare			Represents an IntegerSet object.
	 * @return Returns true if the two sets are equal, and false otherwise.
	 * @throws ClassCastException	If the types of one or more elements in the specified collection are incompatible with this collection.
	 * @throws NullPointerException	If the specified collection contains one or more null elements and this collection does not permit null elements, or if the specified collection is null.
	 */
	public boolean equals(IntegerSet setToCompare) {
		try {
			return integerSet.containsAll(setToCompare.getIntegerSet());
		}
		catch (ClassCastException ex) {
			throw new ClassCastException(ex.getMessage());
		}
		catch (NullPointerException ex) {
			throw new NullPointerException(ex.getMessage());
		}
	}

	/**
	 * Returns true if the set contains the value, otherwise false.
	 * 
	 * @param value	Represents an element of an integer set.
	 * @return True if the set contains the value, otherwise false.
	 */
	public boolean contains(int value) {
		return integerSet.contains(value);
	}

	/**
	 * Returns the largest item in the set; throws a IntegerSetException if the set is empty.
	 * 
	 * @return The largest item in the set.
	 * @throws IntegerSetException	If the set is empty.
	 */
	public int largest() throws IntegerSetException{
		Integer[] setArrayInteger = integerSet.toArray(new Integer[0]);
		int[] setArrayInt = 
				Arrays.stream(setArrayInteger).mapToInt(Integer::intValue).toArray();
		return Arrays.stream(setArrayInt).max().getAsInt();
	}

	/**
	 * Returns the smallest item in the set; throws a IntegerSetException if the set is empty.
	 * 
	 * @return The smallest item in the set.
	 * @throws IntegerSetException	If the set is empty.
	 */
	public int smallest() throws IntegerSetException {
		Integer[] setArrayInteger = integerSet.toArray(new Integer[0]);
		int[] setArrayInt = 
				Arrays.stream(setArrayInteger).mapToInt(Integer::intValue).toArray();
		return Arrays.stream(setArrayInt).min().getAsInt();
	}

	/**
	 * Adds an item to the integer set or does nothing if it is already there.
	 * 
	 * @param item	Represents an item in the integer set.
	 */
 	public void add(int item) {
 		integerSet.add(item); 		
 	}

 	/**
 	 * Removes an item from the set or does nothing if not there.
 	 * 
 	 * @param item					Represents an item in the integer set.
 	 * @throws IntegerSetException	If the set is empty.
 	 */
	public void remove(int item) throws IntegerSetException {
		integerSet.removeIf(i -> i.equals(item));
	} 

	/**
	 * Performs a set union on two integer sets.
	 * 
	 * @param setToUnion			Represents an integer set.
	 * @throws NullPointerException	If the integer set is empty.
	 */
	public void union(IntegerSet setToUnion) {
		try {
			integerSet.addAll(setToUnion.getIntegerSet());
		}
		catch (NullPointerException ex) {
			throw new NullPointerException(ex.getMessage());
		}
	}

	/**
	 * Performs a set intersection.
	 * 
	 * @param setToIntersect		Represents an integer set.
	 * @throws ClassCastException	If the class of an element of this list is incompatible with the specified collection.
	 * @throws NullPointerException	If this list contains a null element and the specified collection does not permit null elements, or if the specified collection is null.
	 */
	public void intersect(IntegerSet setToIntersect) {
		try {
			integerSet.retainAll(setToIntersect.getIntegerSet());
		}
		catch (ClassCastException ex) {
			throw new ClassCastException(ex.getMessage());
		}
		catch (NullPointerException ex) {
			throw new NullPointerException(ex.getMessage());
		}
	} 

	/**
	 * Determines the difference between two sets.
	 * 
	 * @param setToCompare			Represents an integer set.
	 * @throws ClassCastException	If the class of an element of this list is incompatible with the specified collection.
	 * @throws NullPointerException	If this list contains a null element and the specified collection does not permit null elements, or if the specified collection is null.
	 */
	public void diff(IntegerSet setToCompare) {
		try {
			integerSet.removeAll(setToCompare.getIntegerSet());
		}
		catch (ClassCastException ex) {
			throw new ClassCastException(ex.getMessage());
		}
		catch (NullPointerException ex) {
			throw new NullPointerException(ex.getMessage());
		}
	}

	/**
	 * Returns true if the set is empty, false otherwise.
	 * 
	 * @return True if the set is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return integerSet.isEmpty();
	}

	// 
	/**
	 * Returns a string representation of the integer set.
	 * 
	 * @return A string representation of the integer set.
	 */
	public String toString() {
		return integerSet.toString();
	}
}
