package test_3;

/* �����е�����������еĳ���
 * �ϳ�������
 * */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] arr, int n) { //Ѱ����������������������
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLength = 0;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(max < dp[j] && arr[j] < arr[i]) //ֻ���ҵ���arr[i]С�ģ�arr[i]���п����ǵ�����
                    max = dp[j];
            }
            dp[i] = max + 1;
            if(maxLength < dp[i])
                maxLength = dp[i];
        }
        return maxLength;
    }
}
