import java.util.HashMap;
import java.util.Map;

public class TestMain {
	
	public static void main(String[] args) {
		/**
		 * This is the class for testing.
		 */
		System.out.println("This is the testing class.");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("aaa", 1);
		map.put("bbb", 2);
		map.put("ccc", 3);
		
		for (Map.Entry<String, Integer> it : map.entrySet()) {
			String key = it.getKey();
			int value = it.getValue();
			
			System.out.println("Key/Value: "+ key + ", "+ value);
		}
		
		for (int num : map.values()) {
			System.out.println("value: "+ num);
		}
	}

}
