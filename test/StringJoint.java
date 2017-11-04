package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StringJoint {
	public static String findSmallest(String[] strs, int n) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) 
			arr.add(strs[i]);
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String ss1 = s1 + s2;
				String ss2 = s2 + s1;
				// ½«
				char[] c1 = ss1.toCharArray();
				char[] c2 = ss2.toCharArray();
				for (int i = 0; i < ss1.length(); i++) {
					if(c1[i] < c2[i])
						return -1;
					else if(c1[i] > c2[i])
						return 1;
				}
				return 0;
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String s : arr)
			sb.append(s);
		return sb.toString();
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		String[] s = {s1,s2};
		String ss = findSmallest(s, 2);
		System.out.println(ss);
	}
}
