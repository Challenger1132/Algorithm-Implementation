package newcode;

import java.util.Scanner;
/* ��X*Y�ķ����У������ϽǸ���Ϊ��㣬���½Ǹ���Ϊ�յ㣬ÿ��ֻ�������߻��������ߣ�����һ���ж����ֲ�ͬ���߷�
 * ��Ϊ�涨ֻ�������߻��������ߣ���˵�x == 0��ʱ�򣬴����ߵ����±��أ�ֻ�������ߣ����ֻ��һ���߷�
 * ��y == 0��ʱ�򣬴����ߵ����ұ��أ�ֻ�������ߣ����ֻ��һ���߷�
 * */
public class Robot {
    public static int count(int x, int y) {
        if(x == 0 || y == 0)  
            return 1;
        return count(x-1, y) + count(x, y-1);
    }
    public static int countWays(int x, int y){
    	return count(x-1, y-1);
    }
    
    public static int countWays2(int x, int y){
    	/* C(m, n) = m! / (n! * (m-n)!)
    	 * */
    	x = x - 1;
    	y = y - 1;
    	int m = x + y;  // �õ��Ǹ��ӣ������Ǹ��
    	int n = x;
    	int numerator = 1, denominator = 1;
    	for(int i = 2;i <= m; i++)
    		numerator = numerator * i;
    	int temp = 1, temp1 = 1;
    	for (int i = 2; i <= n; i++) 
			temp = temp * i;
		for(int i = 2;i <= (m-n); i++)
			temp1 = temp1 * i;
		denominator = temp * temp1;
		return numerator / denominator;
    }
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int x = in.nextInt(), y = in.nextInt();
			int result = countWays2(x, y);
			System.out.println(result);
		}
		in.close();
	}
}
