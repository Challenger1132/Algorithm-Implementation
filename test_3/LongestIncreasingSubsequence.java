package test_3;

/* 求序列的最长上升子序列的长度
 * 合唱团问题
 * */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] arr, int n) { //寻找整型数组的最长递增子序列
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLength = 0;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(max < dp[j] && arr[j] < arr[i]) //只有找到比arr[i]小的，arr[i]才有可能是递增的
                    max = dp[j];
            }
            dp[i] = max + 1;
            if(maxLength < dp[i])
                maxLength = dp[i];
        }
        return maxLength;
    }
}
