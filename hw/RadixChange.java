package hw;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/* radixOne进制的val转成radixTwo进制的数字
 * 进制在[2, 62]之内,且16进制以内用大写字母表示，例如ADAD表示十六进制的数字，不要用adad表示
 * */
public class RadixChange {
	public static String radixChange(String val, int radixOne, int radixTwo){
		int decimalNum = radixToDec(val, radixOne);  // 将radixOne进制的val转为10进制
		String result = DecToRadix(decimalNum, radixTwo); //将十进制转为radixTwo进制的字符串
		return result;
	}
	
	/* 十进制到任意进制的转换[2, 62]
	 * */
	public static String DecToRadix(int val, int radix){
		if(radix < 2 || radix > 62)
			throw new InputMismatchException("Parameter input mismatch ...");
		
		if(val == 0)
			return "0";
		String helper = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		while(val > 0){
			sb.append(helper.charAt(val % radix)); // 将val % radix映射成某个数字
			val = val / radix;
		}
		return sb.reverse().toString();
	}
	
	/*  任意进制[2, 62]向十进制转换
	 * */
	public static int radixToDec(String val, int radix){
		String helper = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		char[] chs = val.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if(!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')))
				throw new NumberFormatException("Number contains other character ...");
		}
		Arrays.sort(chs);
		int maxRadix = helper.indexOf(chs[chs.length-1]);
		if(radix <= maxRadix || radix < 2 || radix > 62)
			throw new InputMismatchException("Parameter input mismatch ...");
		// 以上是关于异常处理的部分
		
		int total = 0;
		for (int i = 0; i < val.length(); i++) {
			int v = helper.indexOf(val.charAt(i));  // 查找字符代表的真实数字
			int temp = 1;
			for (int j = 0; j < val.length()-i-1; j++)
				temp *= radix;
			total += v*temp;
		}
		return total;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			int radix = in.nextInt();
			int radix2 = in.nextInt();
			String val = radixChange(str, radix, radix2);
			System.out.println(val);
		}
		in.close();
	}
}
