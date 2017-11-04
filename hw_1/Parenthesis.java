package hw_1;

/*  直接使用卡特拉数公式
*/
public class Parenthesis {
    public static int countLegalWays(int n) {
    	int result = 1;
        for (int i = n+2; i <= 2*n; i++)
			result *= i;
        for (int i = 2; i <= n; i++) {
			result /= i;
		}
        return result;
    }
}