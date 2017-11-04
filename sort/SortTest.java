package sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
	public static int[] generateArray(int num, int limit){
		Random rand = new Random();
		int[] arr = new int[num];
		for(int i = 0;i < num;i ++)
			arr[i] = rand.nextInt(limit);
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = generateArray(20, 100);
		System.out.println(Arrays.toString(arr));
		SortAlgo.shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
