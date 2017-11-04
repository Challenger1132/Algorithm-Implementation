package test;

import java.util.HashMap;

public class DistinctSubString {
	public int longestSubstring(String str, int n) {
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLength = 1;
		int pre = maxLength;
		map.put(str.charAt(0), 0);
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			Integer freq = map.get(c);
			map.put(c, i);			
		}
		return 0;
    }
}
