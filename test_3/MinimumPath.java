package test_3;

/* 有一个矩阵map，它每个格子有一个权值,从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和
 * 
 * 可以利用BFS求最短路径，但是官渡优先搜索算法求解最短路径问题要求的是无权图，
 * 对于有权图，用Dijksrta算法
 * 
 * 本题使用动态规划来求解
 * 
 * */
public class MinimumPath {
    public static int getMin(int[][] map) {
    	int xlen = map.length, ylen = map[0].length;
    	int[][] dp = new int[xlen][ylen];
    	dp[0][0] = map[0][0];
    	for(int i = 1; i < xlen; i++)  //dp[i][0]表示只能向下走，不能向右走的路径长度
    		dp[i][0] = map[i][0] + dp[i-1][0];
    	for(int i = 1; i < ylen; i++) //dp[0][i]表示只能向右走，不能向下走的路径长度
    		dp[0][i] = map[0][i] + dp[0][i-1];
    	
    	/* 因为规定只能向右走或者向下走，对于dp[i][j]的状态只能来自与dp[i-1][j]或者dp[i][j-1]
    	 * 因此找到dp[i-1][j]与dp[i][j-1]的最小值加上map[i][j]当前的值
    	 * 就是从00到达点ij的最短路径,并更新dp[i][j]的值，每一个状态就是这样步步为营求解得来的
    	 * 因此最后dp[m][n]就是求解的最短路径
    	 * dp[i][j] = min(dp[i-1][j] + dp[i][j-1]) + map[i][j];
    	 * */

    	for (int i = 1; i < xlen; i++) {
			for (int j = 1; j < ylen; j++) {
				int min = dp[i-1][j] < dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
				dp[i][j] = map[i][j] + min;
			}
		}
    	return dp[xlen-1][ylen-1];
    }
}