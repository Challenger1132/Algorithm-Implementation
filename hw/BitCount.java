package hw;

import java.util.Scanner;
public class BitCount {
	public static int bitCount(int val){
		int total = 0;
		while(val > 0){
			if((val & 1) == 1)
				total++;
			val >>= 1;
		}
		return total;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			System.out.println(Integer.toBinaryString(m));
			System.out.println(bitCount(m));
		}
		in.close();
	}
}
