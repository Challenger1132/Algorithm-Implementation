package sort;

import java.util.Random;
import java.util.Scanner;

public class Test {
	public static int[] shellSort(int[] arr){
		for (int d = arr.length/2; d > 0; d/=2) {  //定义增量序列
			for(int i = d; i < arr.length; i++){ //插入排序
				int ele = arr[i];
				int j = i;
				for( ; j >= d && arr[j-d] > ele; j-=d)
					arr[j] = arr[j-d];
				arr[j] = ele;
			}
		}
		return arr;
	}
	public static int[] shellSort_1(int[] arr){
		for (int d = arr.length/2; d > 0; d/=2) {  //定义增量序列
			for(int i = d; i < arr.length; i++){ //插入排序
				int ele = arr[i];
				int j = i;
				for( ; j >= d && arr[j-d] > ele; j-=d)
					arr[j] = arr[j-d];
				arr[j] = ele;
			}
		}
		return arr;
	}
	public static int[] generateArray(int num, int limit){
		Random rand = new Random();
		int[] arr = new int[num];
		for(int i = 0;i < num;i ++)
			arr[i] = rand.nextInt(limit);
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnt = in.nextInt();
		int[] arr = generateArray(cnt, 100);
		int[] c = new int[cnt];
		System.arraycopy(arr, 0, c, 0, cnt);
		long t1 = System.currentTimeMillis();
		shellSort(arr);
		long t2 = System.currentTimeMillis();
		long t3 = System.currentTimeMillis();
		shellSort_1(c);
		long t4 = System.currentTimeMillis();
		System.out.println((t2-t1) + " ms");
		System.out.println((t4-t3) + " ms");
		
//		boolean flag = true;
//		for(int i = 0;i < cnt;i ++){
//			if(c[i] != arr[i]){
//				flag = false;
//				break;
//			}
//		}
//		System.out.println(flag);
	}
}
