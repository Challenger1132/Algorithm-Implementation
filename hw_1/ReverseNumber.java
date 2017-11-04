package hw_1;

import java.util.Scanner;

public class ReverseNumber {
	public static void num(int num){
		int copy = num;
		int[] arr = new int[10];
		int i = 0;
		while(num > 0){
			int temp = num % 10;
			arr[i++] = temp;
			num /= 10;
		}
		int j;  //第一位不等于0的数字
		for (j = arr.length-1; j >= 0; j--) {
			if(arr[j] != 0)
				break;
		}
		int result = 0;
		for(int k = 0; k <= j; k++){
			int temp = 1;
			for (int l = 0; l < j-k; l++)
				temp *= 10;
			result += arr[k]*temp;
		}
		result += copy;
		System.out.println(result);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			num(num);
		}
		in.close();
	}
}
