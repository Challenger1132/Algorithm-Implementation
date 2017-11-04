package newcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/* 对字符数组中的元素实现全排列
 * 实现去重，当前字符chs[left]和该字符之后的所有不重复字符chs[i]进行交换，如果重复就不进行交换
 * 如果i == left要进行操作，因为这代表了全排列的一种情况
 * 或者从前向后查看，之前有没有已经交换过的重复元素
 * */
public class Permutation {
	public static void permutation(char[] chs, int left, int right, ArrayList<String> arr){
		if(left == right)
			arr.add(String.valueOf(chs));
		else{
			for (int i = left; i <= right; i++) {
				if(!isSwapedBefore(chs, left, i)){  //从left到i之前的元素是否又和arr[i]相同的，没有相同的才进行交换
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
		/* 当startIndex == currIndex的时候，也要进行交换
		 * 所以循环条件是i < currIndex， 而不是i <= currIndex
		 * 该函数表示chs[currIndex]之前有和该元素值相等的元素，就返回true，表示chs[currIndex]已经被交换过
		 * 否则返回false表示chs[currIndex]没有被交换过，就进行交换
		 */
		for (int i = startIndex; i < currIndex; i++) {
			if(chs[i] == chs[currIndex])
				return true; // return true表示之前已经交换过
		}
		return false; // return false 表示之前还没有交换过
	}
	
	public static void permutation2(char[] chs, int left, int right, TreeSet<String> tset){
		/* 直接将元素放到Set里面进行去重
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
