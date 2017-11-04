package test_1;
/* 找出需要排序的最短子数组长度
 * 遍历序列 如果序列是递增的话，不记录index，否则更新index
 * 类似只能序列递增，不能序列递减
 * */
public class MinSubsequence {
    public int shortestSubsequence(int[] arr, int n) {
    	int max = arr[0], min = arr[n-1];
    	int leftIndex = 0, rightIndex = 0;
    	for (int i = 1; i < arr.length; i++)  // 只有后面的数据都>=当前的max值，这样index才会停下来
			if(arr[i] >= max) max = arr[i];
			else leftIndex = i;
    	for (int i = arr.length-2; i >= 0; i--)  //只有后面的数据都<=当前的min，index才会停下来
			if(arr[i] <= min) min = arr[i];
			else rightIndex = i;
		
    	if(leftIndex == rightIndex) return 0;
    	return leftIndex - rightIndex + 1;
    }
}