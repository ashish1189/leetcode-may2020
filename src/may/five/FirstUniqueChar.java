package may.five;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueChar {

	public int firstUniqChar(String s) {
		Map<Character, Integer> counts = new LinkedHashMap<>(s.length());
		for (char c : s.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return s.indexOf(entry.getKey());
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstUniqueChar obj = new FirstUniqueChar();
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println(obj.firstUniqChar("loveleetcode"));
		System.out.println(obj.firstUniqChar("abcbc"));
		System.out.println(obj.firstUniqChar("abcdeabcdabcaba"));
		System.out.println(obj.firstUniqChar("abcdeabcdabcabae"));
	}

}
