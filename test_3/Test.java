package test_3;

import java.util.Scanner;

/**
 * java进制转换
 * Integer.toBinaryString() 将其他进制(8 10 16)转换为2进制，数字以0开头表示8进制，以0x开头表示16进制
 * 相应的有其他进制转化为8进制 Integer.toOctalString()、16进制Integer.toHexString()
 * Integer.valueOf(String s, int radix),将其他进制转化为10进制，
 * 但是传入的字符串s必须是radix形式表示的，也就是说s要和radix相匹配
 * String.parseInt(String s, int radix)功能一样，如果没有radix参数，默认转化为10进制
 * 当然输入的字符串要符合十进制
 * public static Integer valueOf(String s, int radix) throws NumberFormatException {
        return Integer.valueOf(parseInt(s,radix));
    }
 * 
 * */
public class Test {
	public static void main(String[] args) {
		Integer val = Integer.MAX_VALUE;
		Integer val1 = Integer.MIN_VALUE;
		System.out.println(val);
		System.out.println(val1);
		int i = Integer.MAX_VALUE;
		int j = Integer.MIN_VALUE;
		System.out.println(i);
		System.out.println(j);
		System.out.println(i+1);
		System.out.println(j-1);
		System.out.println(Math.pow(2, 31)-1);
		System.out.println(-Math.pow(2, 31));
		System.out.println(Math.pow(2, 15)-1);
		System.out.println(-Math.pow(2, 15));
		System.out.println(Math.pow(2, 16));
		System.out.println(Math.pow(26, 6));
	}
}
