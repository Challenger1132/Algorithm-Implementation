package hw;

public class Swap {
    public int[] getSwap(int[] num) {
    	num[0] = num[0]^num[1];
    	num[1] = num[0]^num[1];
    	num[0] = num[0]^num[1];
    	return num;
    }
    public static void swap(int a, int b){
    	a = a^b;
    	b = a^b;
    	a = a^b;
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    }
}