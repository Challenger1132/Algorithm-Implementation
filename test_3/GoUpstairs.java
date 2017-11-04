package test_3;

/* 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法
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
