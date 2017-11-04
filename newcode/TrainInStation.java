package newcode;

import java.util.Scanner;
import java.util.TreeSet;

/* 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号
 * 要求以字典序排序输出火车出站的序列号
 * */
public class TrainInStation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int cnt = in.nextInt();
			TreeSet<String> set = new TreeSet<>();
			int[] arr = new int[cnt];
			for (int i = 0; i < cnt; i++)
				arr[i] = in.nextInt();
			permutation(arr, 0, arr.length-1, set);
			for (String str : set) {
				for (int j = 0; j < str.length()-1; j++)
					System.out.print(str.charAt(j) + " ");
				System.out.println(str.charAt(str.length()-1));
			}
		}
		in.close();
	}
	public static void permutation(int[] chs, int left, int right, TreeSet<String> set){
		if(left == right){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < chs.length; i++) 
				sb.append(chs[i]);
			set.add(sb.toString());
		}
		else{
			for (int i = left; i <= right; i++) {
				swap(chs, left, i);
				permutation(chs, left + 1, right, set);
				swap(chs, i, left);
			}
		}
	}
	private static void swap(int[] chs, int left, int right){
		int t = chs[left];
		chs[left] = chs[right];
		chs[right] = t;
	}
}
