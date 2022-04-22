/** CSCI 540: Final Exam
 *  Programmer: Ben Corriette
 *  Student ID: @02956064
 * 	Last modified: 04/22/2022
 *  Summary: An implementation of a hash map utilities class
 *  
 *  References: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 *  			https://stackoverflow.com/questions/4234985/how-to-for-each-the-hashmap
 */
package org.howard.edu.lsp.finalexam;

import java.util.HashMap;
import java.util.Map;

/**
 * A hash map utilities class.
 * 
 * @author Ben Corriette
 * 
 */
public class MapUtilities {
	/**
	 * Processes two hash maps to determine the number of common key/value pairs.
	 * 
	 * @param map1 Represents the first hash map.
	 * @param map2 Represents the second hash map.
	 * @return The number of common key/value pairs between the two hash maps.
	 * @throws NullMapException
	 */
	public static int commonKeyValuePairs(
        HashMap<String, String> map1,
        HashMap<String, String> map2) throws NullMapException {
		
		int commonKeyValuePairs = 0;

		// Requirement #1: Throw a NullMapException if either or both maps passed in are null			
		if (map1 == null || map2 == null) {
			// Requirement #1: The exception should be passed “One or both maps are null!” when instantiated
			throw new NullMapException("One or both maps are null!");
		}
		// Requirement #2: Return 0 if either or both maps passed in are empty
		else if (map1.isEmpty() || map2.isEmpty()) {
			return 0;
		}
		// Requirement #3: Enumerate the number of common key/value pairs
		else {
			for(Map.Entry<String, String> entry : map1.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if (map2.containsKey(key)) {
					if (value.equals(map2.get(key))) {
						commonKeyValuePairs++;
					}
				}
			}
		}
		return commonKeyValuePairs;
    }
}
