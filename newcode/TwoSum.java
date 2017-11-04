package newcode;

import java.util.Arrays;
import java.util.HashSet;

/* ��������������������ĺ���sum,�ҵ���������
 * 1��twosum�����ת��,����Ԫ��arr[i]���Ե�ǰԪ��֮�������Ԫ�ز��ö��ֲ���sum-arr[i]�Ƿ����
 * ʱ�临�Ӷ��� Nlog(N)
 * 2��������������飬leftָ���һ��Ԫ�أ�rightָ�����һ��Ԫ�أ�Ȼ�����м俿£
 * ���ҵ�ʱ�临�Ӷ���log(N)
 * 
 * */
public class TwoSum {
	public static int[] sum2(int[] arr, int sum){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			for (int j = i+1; j < arr.length; j++) {
				int index = binarySearch(arr, sum - arr[i]); //��sum��ȥarr[i]�������Ǽ�ȥi
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
