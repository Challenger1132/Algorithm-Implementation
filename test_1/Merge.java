package test_1;

public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
    	int index = A.length-1;
    	int i = n-1, j = m-1;
    	while(j >= 0 && i >= 0) {
    		if(A[i] > B[j]) {
    			A[index--] = A[i--];
    		}
    		else if(A[i] <= B[j]){
    			A[index--] = B[j--];
    		}
    	}
    	while(j >= 0){
    		A[index--] = B[j--];
    	}
    	return A;
    }
}