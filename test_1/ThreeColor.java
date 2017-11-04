package test_1;

import java.util.Arrays;

public class ThreeColor {
    public static int[] sortThreeColor(int[] A, int n) {
        int[] result = new int[3];
        for(int i = 0; i < A.length; i++)
            result[A[i]]++;
        int index = 0;
        for(int i = 0;i < result.length; i++)
            for(int j = 0;j < result[i]; j++)
                A[index++] = i;
        return A;
    }
    public static int[] sortThreeColor_1(int[] arr, int n) {
    	int left = 0, right = arr.length-1;
    	int index = 0;
    	while(index <= right){
    		if(arr[index] == 0){ //交换index和left处的位置的元素
    			int temp = arr[index];
    			arr[index] = arr[left];
    			arr[left] = temp;
    			index++;
    			left++;
    		}
    		else if(arr[index] == 2){  // 交换index和right处的元素
    			int temp = arr[index];
    			arr[index] = arr[right];
    			arr[right] = temp;
    			right--;
    		}
    		else
    			index++;
    	}
    	return arr;
    }
    public static void main(String[] args) {
		int[] arr = {1, 2,  0, 1, 2, 0, 1};
		sortThreeColor(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}