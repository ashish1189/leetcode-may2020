package may.twentytwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharFrequencyString {

	public String frequencySort(String s) {
		Map<Character, Integer> sorted = new HashMap<>();
		String result = "";

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sorted.put(c, sorted.containsKey(c) ? sorted.get(c) + 1 : 1);
		}
		
		sorted = sorted
					.entrySet()
					.stream()
					.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
							LinkedHashMap:: new));

		for(Map.Entry<Character, Integer> entry : sorted.entrySet()) {
			char c = entry.getKey();
			String repeat = new String(new char[sorted.get(c)]).replaceAll("\0", String.valueOf(c));
			result += repeat;
		}

		return result;
    }

	public static void main(String[] args) {
		CharFrequencyString cfs = new CharFrequencyString();
		
		System.out.println(cfs.frequencySort("Aabb"));
		System.out.println(cfs.frequencySort("tree"));
		System.out.println(cfs.frequencySort("cccaaa"));
	}

}
