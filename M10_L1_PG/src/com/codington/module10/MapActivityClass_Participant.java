package com.codington.module10;

// TODO 1 Import java.util.* package in order to use collection API classes.
import java.util.*;
/**
 *
 * Topic : Java Collections
 *
 * Instructions :
 * 1. Activity to implement Map collection of Java Collections Framework
 * 2. Code as per the TODOs
 *
 */

public class MapActivityClass_Participant {


	/**
	 * Type code to create a HashMap of key value pairs<br/>
	 * where key is id of type String and value is a name
	 * @param args
	 */
	public static void main(String[] args) {


		// TODO 2 Create a Map<String, String> object using HashMap constructor
		Map<String,String> map = new HashMap<>();
		// TODO 3 Populate the map with below values using the put() method.
		//	Event ID           Event Name
		//	==============================
        //	E_001              HIGH RIDE
        //	E_002              LOW RIDE
        //	E_003              ZOO
		map.put("E_001", "HIGH RIDE");
		map.put("E_002", "LOW RIDE");
		map.put("E_003", "ZOO");
		// TODO 4 Print the values in console associated with the map key using the get() method.
		System.out.println(map.get("E_001"));
		System.out.println(map.get("E_002"));
		System.out.println(map.get("E_003"));
		// TODO 5 Create a Set<String> object that contains all the map keys retrieved using the keySet() method.
		Set<String> keys = map.keySet();
		// TODO 6 Create a Collection<String>  object that contains all the key values retrieved using the values() method.
		Collection<String> values = map.values();
		// TODO 7 Print the statement in console "List of available events are as below:" before printing the map details.
		System.out.println("List of available events are as below:");
		// TODO 8 Print all the map key collected in Set<String>.
		int contadorKeys = 0;
		for(Iterator<String> iterator = keys.iterator();iterator.hasNext();){
			if(contadorKeys == 0){
				System.out.print("[");
			}
			if(contadorKeys > 0 && contadorKeys < keys.size()){
				System.out.print(iterator.next() + ",");
			}
			if(contadorKeys > keys.size()-1){
				System.out.print(iterator.next() + "]\n");
			}
			contadorKeys++;
		}
		// TODO 9 Print all the map values collected in Collection<String>.
		int contadorValues = 0;
		for(Iterator<String> iterator = values.iterator();iterator.hasNext();){
			if(contadorValues == 0){
				System.out.print("[");
			}
			if(contadorValues > 0 && contadorValues < values.size()){
				System.out.print(iterator.next() + ",");
			}
			if(contadorValues > values.size()-1){
				System.out.print(iterator.next() + "]\n");
			}
			contadorValues++;
		}
	}
}
