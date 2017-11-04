package test;

import java.util.Scanner;

public class StringReverse {
	public static char[] reverse(char[] chs, int left, int right){
		for(int i = 0, j = left;i < (right - left + 1) / 2; i++, j++){
			int index = right - i;
			char c = chs[j];
			chs[j] = chs[index];
			chs[index] = c;
		}
		return chs;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int  i = in.nextInt();
			String str = in.nextLine();
			str = in.nextLine();
			char[] chs = str.toCharArray();
			reverse(chs, 0, i);
			System.out.println(new String(chs));
			reverse(chs, i+1, chs.length-1);
			System.out.println(new String(chs));
			reverse(chs, 0, chs.length-1);
			System.out.println(new String(chs));
		}
		in.close();
	}
}
