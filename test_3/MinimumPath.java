package test_3;

/* ��һ������map����ÿ��������һ��Ȩֵ,�����Ͻǵĸ��ӿ�ʼÿ��ֻ�����һ��������ߣ���󵽴����½ǵ�λ��
 * ·�������е������ۼ���������·���ͣ��������е�·������С��·����
 * 
 * ��������BFS�����·�������ǹٶ����������㷨������·������Ҫ�������Ȩͼ��
 * ������Ȩͼ����Dijksrta�㷨
 * 
 * ����ʹ�ö�̬�滮�����
 * 
 * */
public class MinimumPath {
    public static int getMin(int[][] map) {
    	int xlen = map.length, ylen = map[0].length;
    	int[][] dp = new int[xlen][ylen];
    	dp[0][0] = map[0][0];
    	for(int i = 1; i < xlen; i++)  //dp[i][0]��ʾֻ�������ߣ����������ߵ�·������
    		dp[i][0] = map[i][0] + dp[i-1][0];
    	for(int i = 1; i < ylen; i++) //dp[0][i]��ʾֻ�������ߣ����������ߵ�·������
    		dp[0][i] = map[0][i] + dp[0][i-1];
    	
    	/* ��Ϊ�涨ֻ�������߻��������ߣ�����dp[i][j]��״ֻ̬��������dp[i-1][j]����dp[i][j-1]
    	 * ����ҵ�dp[i-1][j]��dp[i][j-1]����Сֵ����map[i][j]��ǰ��ֵ
    	 * ���Ǵ�00�����ij�����·��,������dp[i][j]��ֵ��ÿһ��״̬������������ΪӪ��������
    	 * ������dp[m][n]�����������·��
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