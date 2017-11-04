package newcode;

import java.util.Scanner;
/* 在X*Y的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 * 因为规定只能向下走或者向右走，因此当x == 0的时候，代表走到了下边沿，只能向右走，因此只有一种走法
 * 当y == 0的时候，代表走到了右边沿，只能向下走，因此只有一种走法
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
    	int m = x + y;  // 用的是格子，而不是格点
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
