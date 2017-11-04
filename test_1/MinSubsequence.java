package test_1;
/* �ҳ���Ҫ�������������鳤��
 * �������� ��������ǵ����Ļ�������¼index���������index
 * ����ֻ�����е������������еݼ�
 * */
public class MinSubsequence {
    public int shortestSubsequence(int[] arr, int n) {
    	int max = arr[0], min = arr[n-1];
    	int leftIndex = 0, rightIndex = 0;
    	for (int i = 1; i < arr.length; i++)  // ֻ�к�������ݶ�>=��ǰ��maxֵ������index�Ż�ͣ����
			if(arr[i] >= max) max = arr[i];
			else leftIndex = i;
    	for (int i = arr.length-2; i >= 0; i--)  //ֻ�к�������ݶ�<=��ǰ��min��index�Ż�ͣ����
			if(arr[i] <= min) min = arr[i];
			else rightIndex = i;
		
    	if(leftIndex == rightIndex) return 0;
    	return leftIndex - rightIndex + 1;
    }
}