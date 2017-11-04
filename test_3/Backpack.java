package test_3;
/* 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大
 * 
dp[x][y]表示物品数量为x,重量不超过y时背包中的总价值
两种情况：1.将x物品不加入到背包中，那么前x-1件物品的总重量不应该超过y	dp[x][y] = dp[x-1][y]
2.将x物品加入到背包中，那么前x-1前物品的总重量不应该超过y-w[x],因此dp[x][y] = dp[x-1][y-w[x]] + v[x];
 * */
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
    	int[] dp = new int[cap+1];
    	for (int i = 0; i < n; i++) {  //对于前i件物品
			for (int j = cap; j >= w[i]; j--)   //剩余空间应该大于第i件商品的重量,这样才能放进去
				dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
			// dp[j]代表前i件商品，重量不超过j的最大价值，如果不放第i件商品,则价值不变
			// 前i-1件商品不超过的重量也不变仍然是dp[j],如果放低i件商品，价值增加v[i]
			// 前i-1件商品不超过的重量变为dp[j-w[i]]
		}
    	return dp[cap];
    }
}
