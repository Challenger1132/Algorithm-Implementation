package newcode;

import java.util.Scanner;
import java.util.TreeSet;

/* ����һ��������N�����������0<N<10���������������վ�����У�һ��N���𳵣�ÿ����������1-9���
 * Ҫ�����ֵ�����������𳵳�վ�����к�
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
