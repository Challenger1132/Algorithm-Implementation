package newcode;

public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        // A��b����һ�����壬A��b���ڵ���Ŀ (n-1)! * 2  -- c1
    	// A��c���ڵ���Ŀ (n-1)! * 2  -- c2
    	// A��b���ڡ�A��c����������ص��Ĳ��֣� b A c��ʣ��n-3��Ԫ��ȫ�ţ� c A b��ʣ��n-3��Ԫ��ȫ��  -- c3
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