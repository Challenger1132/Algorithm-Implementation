package test_1;
public class Gap {
    public static int maxGap(int[] arr, int n) {
        for (int i = 1; i < arr.length; i++) {
			int j = i, ele = arr[i];
			for(; j >= 1 && arr[j-1] > ele; j--)  // index�������� >=1 �������ǰ��������ʹ�±�Խ��
				arr[j] = arr[j-1];
			arr[j] = ele;
		}
        int maxGap = -1;
        for (int i = 1; i < arr.length; i++) 
			if(maxGap < arr[i] - arr[i-1]){
				maxGap = arr[i] - arr[i-1];
		}
        return maxGap;
    }
}