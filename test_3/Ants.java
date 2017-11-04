package test_3;

public class Ants {
    public int[] collision(int n) {
        //����ͷ2�������ͬ˳ʱ�룬ͬ��ʱ��
        int total = 1;
        for(int i = 2; i <= n; i++)
            total *= i;
        int first = total - 2;
        int mcd = maxCommomDivisor(total, first);
        return new int[]{first/mcd, total/mcd};
    }
    public static int maxCommomDivisor(int m, int n){
    	if(m < n){  //��֤m > n
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
    	if(m < n){  //��֤m > n
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
    //��С�����������������ĳ˻��������Լ��
}