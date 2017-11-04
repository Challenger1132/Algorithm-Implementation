package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < r.nextInt(20) + 5; i++)
			arr.add(r.nextInt(100));
		System.out.println(arr);
		Collections.reverse(arr);
		System.out.println(arr);
	}
}
