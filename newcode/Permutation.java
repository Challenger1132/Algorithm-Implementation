package newcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/* ���ַ������е�Ԫ��ʵ��ȫ����
 * ʵ��ȥ�أ���ǰ�ַ�chs[left]�͸��ַ�֮������в��ظ��ַ�chs[i]���н���������ظ��Ͳ����н���
 * ���i == leftҪ���в�������Ϊ�������ȫ���е�һ�����
 * ���ߴ�ǰ���鿴��֮ǰ��û���Ѿ����������ظ�Ԫ��
 * */
public class Permutation {
	public static void permutation(char[] chs, int left, int right, ArrayList<String> arr){
		if(left == right)
			arr.add(String.valueOf(chs));
		else{
			for (int i = left; i <= right; i++) {
				if(!isSwapedBefore(chs, left, i)){  //��left��i֮ǰ��Ԫ���Ƿ��ֺ�arr[i]��ͬ�ģ�û����ͬ�ĲŽ��н���
					swap(chs, left, i);
					permutation(chs, left + 1, right, arr);
					swap(chs, i, left);
				}
			}
		}
	}
	private static void swap(char[] chs, int left, int right){
		char t = chs[left];
		chs[left] = chs[right];
		chs[right] = t;
	}
	private static boolean isSwapedBefore(char[] chs, int startIndex, int currIndex){
		/* ��startIndex == currIndex��ʱ��ҲҪ���н���
		 * ����ѭ��������i < currIndex�� ������i <= currIndex
		 * �ú�����ʾchs[currIndex]֮ǰ�к͸�Ԫ��ֵ��ȵ�Ԫ�أ��ͷ���true����ʾchs[currIndex]�Ѿ���������
		 * ���򷵻�false��ʾchs[currIndex]û�б����������ͽ��н���
		 */
		for (int i = startIndex; i < currIndex; i++) {
			if(chs[i] == chs[currIndex])
				return true; // return true��ʾ֮ǰ�Ѿ�������
		}
		return false; // return false ��ʾ֮ǰ��û�н�����
	}
	
	public static void permutation2(char[] chs, int left, int right, TreeSet<String> tset){
		/* ֱ�ӽ�Ԫ�طŵ�Set�������ȥ��
		 * */
		if(left == right)
			tset.add(String.valueOf(chs));
		else{
			for (int i = left; i <= right; i++) {
				swap(chs, left, i);
				permutation2(chs, left + 1, right, tset);
				swap(chs, i, left);
			}
		}
	}

	private static int factorial(int n){
		int result = 1;
		for (int i = 2; i <= n; i++) 
			result *= i;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			char[] chs = str.toCharArray();
			ArrayList<String> arr = new ArrayList<String>();
			permutation(chs, 0, chs.length - 1, arr);
			
			String str1 = in.nextLine();
			char[] chs1 = str1.toCharArray();
			TreeSet<String> tset = new TreeSet<>();
			permutation2(chs1, 0, chs1.length - 1, tset);

			System.out.println("result = " + factorial(str.length()));
			System.out.println("arr.size = " + arr.size());
			System.out.println("tset.size = " + tset.size());
			
		}
		in.close();
	}
}
