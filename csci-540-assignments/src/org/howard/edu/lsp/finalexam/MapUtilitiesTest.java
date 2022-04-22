/** CSCI 540: Final Exam
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 04/22/2022
 *  Summary: A JUnit test case for the custom hash map utilities class.
 *  
 *  References: org.howard.edu.lsp.assignment6.junit.IntegerSetTest
 *  			https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
 */
package org.howard.edu.lsp.finalexam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test case for the custom hash map utilities class.
 * 
 * @author Ben Corriette
 *
 */
class MapUtilitiesTest {
	
	HashMap<String, String> mapTest1;
	HashMap<String, String> mapTest2;

	/**
	 * Instantiate both sample hash maps for testing.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mapTest1 = new HashMap<String, String>();
		mapTest1.put("Alice", "Healthy");
		mapTest1.put("Mary", "Ecastic");
		mapTest1.put("Bob", "Happy");
		mapTest1.put("Chuck", "Fine");
		mapTest1.put("Felix", "Sick");

		mapTest2 = new HashMap<String, String>();
		mapTest2.put("Mary", "Ecastic");
		mapTest2.put("Felix", "Healthy");
		mapTest2.put("Ricardo", "Superb");
		mapTest2.put("Tam", "Fine");
		mapTest2.put("Bob", "Happy");
	}

	/**
	 * Test method for {@link org.howard.edu.lsp.finalexam.MapUtilities#commonKeyValuePairs(java.util.HashMap, java.util.HashMap)}.
	 * @throws NullMapException 
	 */
	@Test
	@Order(1)
	@DisplayName("commonKeyValuePairs(): Testing if there is an accurate number of common key/value pairs")
	final void testCommonKeyValuePairs() throws NullMapException {
		assertEquals(2, MapUtilities.commonKeyValuePairs(mapTest1, mapTest2), "The number of common key/value pairs is inaccurate");
		// Add three more common key/value pairs and test again
		mapTest1.put("Bernard", "Smart");
		mapTest1.put("Danda", "Studious");
		mapTest1.put("Legand", "Articulate");
		mapTest2.put("Bernard", "Smart");
		mapTest2.put("Danda", "Studious");
		mapTest2.put("Legand", "Articulate");
		assertEquals(5, MapUtilities.commonKeyValuePairs(mapTest1, mapTest2), "The number of common key/value pairs is inaccurate");
	}
	
	/**
	 * Test method for {@link org.howard.edu.lsp.finalexam.MapUtilities#commonKeyValuePairs(java.util.HashMap, java.util.HashMap)}.
	 * @throws NullMapException 
	 */
	@Test
	@Order(2)
	@DisplayName("commonKeyValuePairs() throws NullMapException: Testing if the operation throws an NullMapException due to empty hash map(s)")
	void CommonKeyValuePairsWithException() throws NullMapException {
		// Set one hash map to null, then test
		mapTest1 = null;
		assertThrows(NullMapException.class, () -> MapUtilities.commonKeyValuePairs(mapTest1, mapTest2));		
	}
	
	/**
	 * Test method for {@link org.howard.edu.lsp.finalexam.MapUtilities#commonKeyValuePairs(java.util.HashMap, java.util.HashMap)}.
	 * @throws NullMapException 
	 */
	@Test
	@Order(3)
	@DisplayName("commonKeyValuePairs(): Testing if the method returns 0 if one or more hash maps are empty")
	final void testCommonKeyValuePairsWithEmptyMaps() throws NullMapException {
		// Clear out one of the hash maps, then test
		mapTest2.clear();
		assertEquals(0, MapUtilities.commonKeyValuePairs(mapTest1, mapTest2), "The number of common key/value pairs is inaccurate");
	}
}
