package test_3;
/* 字符串的最小编辑距离
 * */
public class MinEditCost {
    public int findMinCost(String stra, int n, String strb, int m, int ic, int dc, int rc) {
        int alen = stra.length(), blen = strb.length();
        int[][] dp = new int[alen+1][blen+1];
        for (int i = 0; i < dp.length; i++)
			dp[i][0] = i*dc;
        for (int i = 0; i < dp[0].length; i++)
			dp[0][i] = i*ic;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int cost1 = 0;
				if(stra.charAt(i-1) == strb.charAt(j-1))
					cost1 = dp[i-1][j-1];
				else
					cost1 = dp[i-1][j-1] + rc;  //加入转换代价
				int cost2 = dp[i-1][j] + dc;
				int cost3 = dp[i][j-1] + ic;
				int temp = cost1 > cost2 ? cost2 : cost1;
				dp[i][j] = temp > cost3 ? cost3 : temp;
			}
		}
		return dp[alen][blen];
    }
}