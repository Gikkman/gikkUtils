package com.gikk.java.aop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InvokationMapper {
	private static Map<String, Map<String, Invocation>> map = new HashMap<>();	
	private InvokationMapper() {}
		
		
	/**Adds a method to the method map, which can later be retrieved. Each key can map to multiple methods, but each method's ID must be unique
	 * for a given key
	 * 
	 * @param key 
	 * @param id
	 * @param method 
	 * @return True if id was not listed for the given key
	 */
	public static synchronized boolean addMethod(String key, String id, Invocation method){		
		if( map.containsKey(key) ) {
			Map<String, Invocation> inner = map.get(key);
			if( inner.containsKey(id) ){
				return false;
			}
			else{
				inner.put(id, method);
				return true;
			}
		}
		else {
			Map<String, Invocation> inner = new HashMap<>();
			inner.put(id, method);
			map.put(key, inner);
			return true;
		}			
	}
	
	/**Removes the method with the given id for the given key
	 * 
	 * @param key
	 * @param id
	 * @return True if a method with the given id was found for the given key
	 */
	public static synchronized boolean removeMethod(String key, String id){
		if( map.containsKey(key) ){
			Map<String, Invocation> inner = map.get(key);
			if( inner.containsKey(id) ){
				inner.remove(id);
				if( inner.size() == 0 ){
					map.remove(key);
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**Fetches the collection of methods registered at a certain key. The fetching unit can later execute the methods.
	 * 
	 * @param key
	 * @return All invocations registered for a certain key OR null if no invocations are registered at the key
	 */
	public static synchronized Collection<Invocation> getInvokations(String key){
		if(!map.containsKey(key)){		
			return null;
		}
		else {
			return map.get(key).values();
		}
	}
}
