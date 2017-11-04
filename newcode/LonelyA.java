package newcode;

public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        // A与b看做一个整体，A与b相邻的数目 (n-1)! * 2  -- c1
    	// A与c相邻的数目 (n-1)! * 2  -- c2
    	// A与b相邻、A与c相邻中情况重叠的部分： b A c，剩下n-3个元素全排； c A b，剩下n-3个元素全排  -- c3
    	// result = n! - c1 - c2 + c3
    	int Ab = facorial(n-1) * 2;
    	int Ac = facorial(n-1) * 2;
    	int Abc = facorial(n-2) * 2;
    	int result = facorial(n) - Ab - Ac + Abc;
    	return result;
    }
    public static int facorial(int n){
    	int result = 1;
    	for (int i = 2; i <= n; i++) {
			result *= i;
		}
    	return result;
    }
}