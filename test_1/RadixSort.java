package test_1;

import java.util.Arrays;
import java.util.Scanner;

/* ¼ÆÊıÅÅĞòËã·¨  --   Í°
 * */
public class RadixSort {
    public static int[] radixSort(int[] A, int n) {
    	int max = 0, min = 0;
    	for (int i = 0; i < A.length; i++) {
			max = Math.max(A[i], max);
			min = Math.min(A[i], min);
		}
    	int[] bucket = new int[max - min + 1];
        for(int i = 0;i < A.length; i++)
            bucket[A[i]-min]++;
        int cnt = 0;
        for (int i = 0; i < bucket.length; i++) 
			for (int j = 0; j < bucket[i]; j++) 
				A[cnt++] = i+min;
        return A;
    }
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int c = in.nextInt();
    	int[] arr = new int[c];
		for (int i = 0; i < c; i++) {
			arr[i] = in.nextInt();
		}
		radixSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
