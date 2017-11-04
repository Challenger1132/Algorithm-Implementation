package newcode;
/* n����ͬ���ǹ����ָ�m���ˣ�ÿ������һ�ţ����ж����ַַ�
 * ����n��m���뷵�ط���������֤nС�ڵ���12����mС�ڵ���n
 * 
 * 1 2 3 4 ... n-2 n-1 n
 * n�������γ�n-1���������Ŀת��Ϊ��n-1������в���m-1�����壬�������Ϊm���� C(n-1, m-1)
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
