package test_3;

/* ��n��̨�ף�һ����ÿ����һ���������������ж���������n��̨�׵ķ���
 * */
public class GoUpstairs {
    public int countWays(int n) {
    	if(n == 1 || n == 2)
    		return n;
    	return countWays(n-1) + countWays(n-2);
    }
    
    public int countWays2(int n){
    	int f1 = 1;
    	int f2 = 2;
    	int f3 = 0;
    	for (int i = 3; i <= n; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
    	return f3;
    }
}
