package test_3;

import java.util.Scanner;

/**
 * java����ת��
 * Integer.toBinaryString() ����������(8 10 16)ת��Ϊ2���ƣ�������0��ͷ��ʾ8���ƣ���0x��ͷ��ʾ16����
 * ��Ӧ������������ת��Ϊ8���� Integer.toOctalString()��16����Integer.toHexString()
 * Integer.valueOf(String s, int radix),����������ת��Ϊ10���ƣ�
 * ���Ǵ�����ַ���s������radix��ʽ��ʾ�ģ�Ҳ����˵sҪ��radix��ƥ��
 * String.parseInt(String s, int radix)����һ�������û��radix������Ĭ��ת��Ϊ10����
 * ��Ȼ������ַ���Ҫ����ʮ����
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
