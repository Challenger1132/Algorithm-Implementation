package hw;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/* radixOne���Ƶ�valת��radixTwo���Ƶ�����
 * ������[2, 62]֮��,��16���������ô�д��ĸ��ʾ������ADAD��ʾʮ�����Ƶ����֣���Ҫ��adad��ʾ
 * */
public class RadixChange {
	public static String radixChange(String val, int radixOne, int radixTwo){
		int decimalNum = radixToDec(val, radixOne);  // ��radixOne���Ƶ�valתΪ10����
		String result = DecToRadix(decimalNum, radixTwo); //��ʮ����תΪradixTwo���Ƶ��ַ���
		return result;
	}
	
	/* ʮ���Ƶ�������Ƶ�ת��[2, 62]
	 * */
	public static String DecToRadix(int val, int radix){
		if(radix < 2 || radix > 62)
			throw new InputMismatchException("Parameter input mismatch ...");
		
		if(val == 0)
			return "0";
		String helper = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		while(val > 0){
			sb.append(helper.charAt(val % radix)); // ��val % radixӳ���ĳ������
			val = val / radix;
		}
		return sb.reverse().toString();
	}
	
	/*  �������[2, 62]��ʮ����ת��
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
		// �����ǹ����쳣����Ĳ���
		
		int total = 0;
		for (int i = 0; i < val.length(); i++) {
			int v = helper.indexOf(val.charAt(i));  // �����ַ��������ʵ����
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
