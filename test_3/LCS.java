package test_3;
/* ���������ַ���stra��strb�����������ַ���������������еĳ���
 * ����������в�Ҫ������
 * ���磬A="1A2C3D4B56����B="B1D23CA45B6A������123456"����"12C4B6"���������������
 * */
public class LCS {
    public int findLCS(String stra, int lena, String strb, int lenb) {
        int[][] dp = new int[lena+1][lenb+1];        
        // dp[i][0] = 0; //stra��ǰi���ַ���strb��ǰ0���ַ�������������еĳ���Ϊ0
        // dp[0][i] = 0; //stra��ǰ0���ַ���strb��ǰi���ַ�������������еĳ���Ϊ0
        // dpĬ�ϳ�ʼ��Ϊ0    
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
    
    /* �������ַ�����������Ӵ���������Ӵ�Ҫ����������
     * ��ǰ�ַ���ͬ dp[i][j] = dp[i-1][j-1] + 1;����dp[i][j] = 0;
     * �ڼ��¼dp[i][j]�����ֵ
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
