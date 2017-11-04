package test_3;
/* 给定两个字符串stra和strb，返回两个字符串的最长公共子序列的长度
 * 最长公共子序列不要求连续
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列
 * */
public class LCS {
    public int findLCS(String stra, int lena, String strb, int lenb) {
        int[][] dp = new int[lena+1][lenb+1];        
        // dp[i][0] = 0; //stra的前i个字符和strb的前0个字符的最长公共子序列的长度为0
        // dp[0][i] = 0; //stra的前0个字符和strb的前i个字符的最长公共子序列的长度为0
        // dp默认初始化为0    
        for (int i = 1; i <= lena; i++) {
			for (int j = 1; j <= lenb; j++) {
				if(stra.charAt(i-1) == strb.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
        return dp[lena][lenb];
    }
    
    /* 求两个字符创的最长公共子串，最长公共子串要求是连续的
     * 当前字符相同 dp[i][j] = dp[i-1][j-1] + 1;否则dp[i][j] = 0;
     * 期间记录dp[i][j]的最大值
     * */
	public static String findLccs(String stra, String strb){
		int lena = stra.length();
		int lenb = strb.length();
		
		int[][] dp = new int[lena+1][lenb+1];
		int max = 0;
		int endIndex = 0;
		for (int i = 1; i <= lena; i++) {
			for (int j = 1; j <= lenb; j++) {
				if(stra.charAt(i-1) == strb.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = 0;
				if(max < dp[i][j]){
					max = dp[i][j];
					endIndex = i;
				}
			}
		}
		return stra.substring(endIndex-max, endIndex);
	}
}
