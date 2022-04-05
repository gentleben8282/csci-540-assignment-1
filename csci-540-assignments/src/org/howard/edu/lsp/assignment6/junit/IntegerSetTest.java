/** CSCI 540: Assignment #6
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 04/04/2022
 *  Summary: A JUnit test implementation of the integer set class.
 *  
 *  References: Class Lecture Recording (03-24-2022)
 *  			https://www.vogella.com/tutorials/JUnit/article.html
 */
package org.howard.edu.lsp.assignment6.junit;

import org.howard.edu.lsp.assignment6.integerset.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * An JUnit test implementation of the integer set class.
 * 
 * @author Ben Corriette
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class IntegerSetTest {
	
	IntegerSet set1;

	/**
	 * Instantiate and initialize an IntegerSet object before each test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		set1 = new IntegerSet();
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
	}

	@Test
	@Order(1)
	@DisplayName("toString(): Testing for an accurate string representation of the collection")
	void testToString() {
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", set1.toString(), "The string representation of the collection is inaccurate");
		// Add a few more elements and test again
		set1.add(11);
		set1.add(12);
		set1.add(13);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]", set1.toString(), "The string representation of the collection is inaccurate");
	}
	
	@Test
	@Order(2)
	@DisplayName("smallest(): Testing for the smallest element in the collection")
	void testSmallest() throws IntegerSetException {
		if (set1 != null) {
			assertTrue(set1.smallest() == 1, "The integer 1 is not the smallest element in the collection");
			// Add a new smallest element and test again
			set1.add(0);
			assertFalse(set1.smallest() == 1, "The integer 1 is the smallest element in the collection");
		}
	}
	
	@Test
	@Order(3)
	@DisplayName("smallest() throws IntegerSetException: Testing if the operation throws an IntegerSetException due to empty collection")
	void testSmallestWithException() throws IntegerSetException {
		set1.clear();
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.smallest());
		assertEquals(0, set1.length(), "The collection is not empty");
		String expectedMessage = "The set is empty";
		assertEquals(expectedMessage, exception.getMessage(), "The exception message returned is inconsistent with the expected exception message");
	}
	
	@Test
	@Order(4)
	@DisplayName("largest(): Testing for the largest element in the collection")
	void testLargest() throws IntegerSetException {
		if (set1 != null) {
			assertTrue(set1.largest() == 10, "The integer 10 is not the largest element in the collection");
			// Add a new largest element and test again
			set1.add(11);
			assertFalse(set1.largest() == 10, "The integer 10 is the largest element in the collection");
		}
	}
	
	@Test
	@Order(5)
	@DisplayName("largest() throws IntegerSetException: Testing if the operation throws an IntegerSetException due to empty collection")
	void testLargestWithException() throws IntegerSetException {
		set1.clear();
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.largest());
		assertEquals(0, set1.length(), "The collection is not empty");
		String expectedMessage = "The set is empty";
		assertEquals(expectedMessage, exception.getMessage(), "The exception message returned is inconsistent with the expected exception message");
	}
	
	@Test
	@Order(6)
	@DisplayName("union(): Testing for the result of a union between two collections and then three collections")
	void testUnion() {
		// Second Set
		IntegerSet set2 = new IntegerSet();
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
		
		if (set1 != null) {
			set1.union(set2);
			assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]", set1.toString(), "The union between the two collections is not correct");
		}
		
		// Third Set
		IntegerSet set3 = new IntegerSet();
		set3.add(21);
		set3.add(22);
		set3.add(23);
		set3.add(24);
		set3.add(25);
		
		if (set1 != null && set2 != null) {
			set1.union(set3);
			assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]", set1.toString(), "The union between the three collections is not correct");
		}
	}
	
	@Test
	@Order(7)
	@DisplayName("intersect(): Testing for the result of an intersect between two pairs of collections")
	void testIntersect() {
		// Second set
		IntegerSet set2 = new IntegerSet();
		set2.add(8);
		set2.add(9);
		set2.add(10);
		set2.add(11);
		set2.add(12);
		set2.add(13);
		set2.add(14);
		set2.add(15);
		set2.add(16);
		set2.add(17);
		
		if (set1 != null) {
			set1.intersect(set2);
			assertEquals("[8, 9, 10]", set1.toString(), "The intersect between the first two collections is not correct");
		}
		
		// Third Set
		IntegerSet set3 = new IntegerSet();
		set3.add(17);
		set3.add(18);
		set3.add(19);
		set3.add(20);
		set3.add(21);
		
		if (set2 != null) {
			set2.intersect(set3);
			assertEquals("[17]", set2.toString(), "The intersect between the second two collections is not correct");
		}
	}
	
	@Test
	@Order(8)
	@DisplayName("diff(): Testing for the result of the difference between two pairs of collections")
	void testDiff() {
		// Second set
		IntegerSet set2 = new IntegerSet();
		set2.add(8);
		set2.add(9);
		set2.add(10);
		set2.add(11);
		set2.add(12);
		set2.add(13);
		set2.add(14);
		set2.add(15);
		set2.add(16);
		set2.add(17);
		
		if (set1 != null) {
			set1.diff(set2);
			assertEquals("[1, 2, 3, 4, 5, 6, 7]", set1.toString(), "The difference between the first two collections is not correct");
		}
		
		// Third Set
		IntegerSet set3 = new IntegerSet();
		set3.add(17);
		set3.add(18);
		set3.add(19);
		set3.add(20);
		set3.add(21);
		
		if (set1 != null && set2 != null) {
			set2.diff(set3);
			assertEquals("[8, 9, 10, 11, 12, 13, 14, 15, 16]", set2.toString(), "The difference between the second two collections is not correct");
		}
	}
	
	@Test
	@Order(9)
	@DisplayName("equals(): Testing if two collections are equal")
	void testEquals() {
		// Create and test unequal set
		IntegerSet set2 = new IntegerSet();
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
		
		if (set1 != null) {
			assertFalse(set1.equals(set2), "The two collections are equal");
		}
		
		// Create and test equal set
		IntegerSet set3 = new IntegerSet();
		set3.add(1);
		set3.add(2);
		set3.add(3);
		set3.add(4);
		set3.add(5);
		set3.add(6);
		set3.add(7);
		set3.add(8);
		set3.add(9);
		set3.add(10);
		
		if (set1 != null) {
			assertTrue(set1.equals(set3), "The two collections are not equal");
		}
	}
	
	@Test
	@Order(10)
	@DisplayName("length(): Testing if the collection's length is accurate")
	void testLength() throws IntegerSetException {
		if (!set1.isEmpty()) {
			assertEquals(10, set1.length(), "The collection's length is inaccurate");
			// Remove half of the collection's elements and then test again
			set1.remove(1);
			set1.remove(2);
			set1.remove(3);
			set1.remove(4);
			set1.remove(5);
			assertEquals(5, set1.length(), "The collection's length is inaccurate");
		}
	}
	
	@Test
	@Order(11)
	@DisplayName("contains(): Testing if the collection contains a certain element")
	void testContains() {
		assertFalse(set1.contains(11), "The collection contains the integer 11");
		// Add the missing element and test again
		set1.add(11);
		assertTrue(set1.contains(11), "The collection does not contain the integer 11");
	}
	
	@Test
	@Order(12)
	@DisplayName("remove(): Testing if the collection removes a certain element")
	void testRemove() throws IntegerSetException {
		if (!set1.isEmpty()) {
			set1.remove(10);
			assertFalse(set1.contains(10), "The integer 10 was not removed from the collection");
			// Remove another element and test again
			set1.remove(9);
			assertFalse(set1.contains(9), "The integer 9 was not removed from the collection");
		}
	}
	
	@Test
	@Order(13)
	@DisplayName("remove() throws IntegerSetException: Testing if the operation throws an IntegerSetException due to empty collection")
	void testRemoveWithException() throws IntegerSetException {
		set1.clear();
		Throwable exception = assertThrows(IntegerSetException.class, () -> set1.remove(10), "The collection is empty");
		assertEquals(0, set1.length(), "The collection is not empty");
		String expectedMessage = "The set is empty";
		assertEquals(expectedMessage, exception.getMessage(), "The exception message returned is inconsistent with the expected exception message");
	}
	
	@Test
	@Order(14)
	@DisplayName("clear(): Testing if the collection has been cleared")
	void testClear() {
		set1.clear();
		assertFalse(set1.length() > 0, "The collection has not been cleared");
		// Add an element and test again
		set1.add(1);
		assertTrue(set1.length() > 0, "The collection has been cleared");
	}
	
	@Test
	@Order(15)
	@DisplayName("isEmpty(): Testing if the collection is empty")
	void testIsEmpty() {
		set1.clear();
		assertEquals(true, set1.isEmpty(), "The collection is not empty");
		// Add an element and test again
		set1.add(1);
		assertNotEquals(true, set1.isEmpty(), "The collection is empty");
	}
}
