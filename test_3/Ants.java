package test_3;

public class Ants {
    public int[] collision(int n) {
        //不碰头2种情况，同顺时针，同逆时针
        int total = 1;
        for(int i = 2; i <= n; i++)
            total *= i;
        int first = total - 2;
        int mcd = maxCommomDivisor(total, first);
        return new int[]{first/mcd, total/mcd};
    }
    public static int maxCommomDivisor(int m, int n){
    	if(m < n){  //保证m > n
    		int temp = m;
    		m = n;
    		n = temp;
    	}
    	if(m % n == 0)
    		return n;
    	else
    		return maxCommomDivisor(n, m%n);
    }
    public static int maxCommomDivisor2(int m, int n){
    	if(m < n){  //保证m > n
    		int temp = m;
    		m = n;
    		n = temp;
    	}
    	while(m % n != 0){
    		int temp = m % n;
    		m = n;
    		n = temp;
    	}
    	return n;
    }
    //最小公倍数等于两个数的乘积除以最大公约数
}