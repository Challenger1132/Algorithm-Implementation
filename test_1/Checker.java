package test_1;

public class Checker {
    public static boolean checkDuplicate(int[] arr, int n) {
    	for(int i = 1; i< arr.length; i++){
    		int j = i, ele = arr[i];
    		for(; j > 0 && arr[j-1] > ele; j--)
    			arr[j] = arr[j-1];
    		arr[j] = ele;
    	}
    	int temp = arr[0];
    	for (int i = 1; i < arr.length; i++) {
			if(temp == arr[i])
				return true;
			temp = arr[i];
		}
    	return false;
    }
    public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,5,6};
		boolean flag = checkDuplicate(arr, arr.length);
		System.out.println(flag);
	}
}