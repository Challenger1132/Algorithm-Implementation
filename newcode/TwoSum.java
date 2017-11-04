package newcode;

import java.util.Arrays;
import java.util.HashSet;

/* 在数组里面查找两个数的和是sum,找到立即返回
 * 1、twosum问题的转换,对于元素arr[i]，对当前元素之后的所有元素采用二分查找sum-arr[i]是否存在
 * 时间复杂度是 Nlog(N)
 * 2、对于有序的数组，left指向第一个元素，right指向最后一个元素，然后向中间靠拢
 * 查找的时间复杂度是log(N)
 * 
 * */
public class TwoSum {
	public static int[] sum2(int[] arr, int sum){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			for (int j = i+1; j < arr.length; j++) {
				int index = binarySearch(arr, sum - arr[i]); //是sum减去arr[i]，而不是减去i
				if(index > i && index > 0)
					return new int[]{arr[i], arr[index]};
			}
		}
		return new int[]{-1, -1};
	}
	public static int[] sumtwo(int[] arr, int sum){
		Arrays.sort(arr);
		int left = 0, right = arr.length-1;
		while(left < right){
			if(arr[left] + arr[right] < sum)
				left++;
			else if(arr[left] + arr[right] > sum)
				right--;
			else
				return new int[]{arr[left], arr[right]};
		}
		return new int[]{-1, -1};
	}
	
	public static int[] sumtwo2(int[] arr, int sum){
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			int diff = sum - arr[i];
			if(!hset.contains(arr[i]))
				hset.add(diff);
			else
				return new int[]{arr[i], diff};
		}
		return new int[]{-1, -1};
	} 
	private static int binarySearch(int[] arr, int key){
		int left = 0;
		int right = arr.length-1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(arr[mid] > key)
				right = mid - 1;
			else if(arr[mid] < key)
				left = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{2,4,6,3,67,9,0};
		int[] result = sumtwo2(arr, 10);
		System.out.println(Arrays.toString(result));
	}
}
