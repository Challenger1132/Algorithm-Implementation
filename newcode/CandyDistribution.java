package newcode;
/* n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n
 * 
 * 1 2 3 4 ... n-2 n-1 n
 * n个数字形成n-1个间隔，题目转化为在n-1个间隔中插入m-1个隔板，将整体分为m部分 C(n-1, m-1)
 * */
public class CandyDistribution {
    public int getWays(int n, int m) {
        if(n > 12 || n < m)
        	return 0;
        int a = factorial(n - 1);
        int b = factorial(m - 1);
        int c = factorial(n - m);
        return a / (b*c);
    }
    public static int factorial(int n){
    	int result = 1;
    	for(int i = 2;i <= n; i++){
    		result *= i;
    	}
    	return result;
    }
}
