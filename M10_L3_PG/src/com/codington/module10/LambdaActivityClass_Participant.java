package com.codington.module10;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
*
* Topic : Java Collections
*
* Instructions :
* 1. Activity to implement Map collection of Java Collections Framework using Lambda Expression
* 2. Code as per the TODOs
*
*/

public class LambdaActivityClass_Participant {

	/**
	 * Type code to create a HashMap of key value pairs<br/>
	 * where key is id of type String and value is a location of type string
	 *
	 * Use Stream and Lambda Expression to filter values of map and create a new filtered map from that data
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO 1 Create a Map<String, String> object using HashMap constructor.
		Map<String,String> map = new HashMap<String,String>();
		// TODO 2 Populate the map using the put() method. Fill at least 6 values in Map with Key as Event ID (example: E_001) and value as Event location (North or South).
		map.put("E_001","North");
		map.put("E_002","North");
		map.put("E_003","South");
		map.put("E_004","North");
		map.put("E_005","South");
		map.put("E_006","North");
		// TODO 3 Create a Set<String> object that contains all the map keys retrieved using the keySet() method.
		Set<String> keys = map.keySet();
		// TODO 4 Create a Collection<String>  object that contains all the key values retrieved using the values() method.
		Collection<String> values = map.values();
		// TODO 5 Print the statement in console "List of available events are as below:" before printing the map details.
		System.out.println("List of available events are as below:");
		// TODO 6 Print all the map key collected in Set<String>.
		int contadorKeys = 0;
		for(String s : keys){
			if(contadorKeys == 0){
				System.out.print("[");
			}
			if(contadorKeys > 0 && contadorKeys < keys.size()){
				System.out.print(s + ",");
			}
			if(contadorKeys == keys.size()-1){
				System.out.print(s + "]\n");
			}
			contadorKeys++;
		}
		// TODO 7 Print all the map values collected in Collection<String>.
		int contadorValues = 0;
		for(String s : values){
			if(contadorValues == 0){
				System.out.print("[");
			}
			if(contadorValues > 0 && contadorValues < keys.size()){
				System.out.print(s + ",");
			}
			if(contadorValues == values.size()-1){
				System.out.print(s + "]\n");
			}
			contadorValues++;
		}
		// TODO 8 Print the statement in console "List of available events in NORTH location are as below:" before printing the updated map details.
		System.out.println("List of available events in NORTH location are as below:");
		// TODO 9 Print the events in North location using Lambda expression as -
		//			a)	Get a stream using map entrySet.
		//			b)	Filter stream only for map values as "North" location:
		//				"e -> e.getValue().equalsIgnoreCase("North")".
		//			c)	Print the map keys for value “North” location:
		//				"forEach(e -> System.out.println(e.getKey()))"
		map.entrySet().stream().
			filter(e -> e.getValue().equalsIgnoreCase("north")).
			forEach(e -> System.out.println(e.getKey()));
		// Como meter el resultado en una variable para mostrarlo luego
		/*System.out.println("\n\n\n----------");
		List<Map.Entry<String,String>> test = map.entrySet().stream().filter(
						e -> e.getValue().equalsIgnoreCase("north")
					).collect(
						Collectors.toList()
					);
		for(Map.Entry<String, String> m: test){
			System.out.println(m.getKey() + ": " + m.getValue());
		}
		*/
	}
}


