package test_1;
public class Gap {
    public static int maxGap(int[] arr, int n) {
        for (int i = 1; i < arr.length; i++) {
			int j = i, ele = arr[i];
			for(; j >= 1 && arr[j-1] > ele; j--)  // index必须满足 >=1 这才能向前跳动，不使下标越界
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