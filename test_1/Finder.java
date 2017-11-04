package test_1;

public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        int i = n-1, j = 0;
    	while(i >= 0 && j < m){
        	if(x > mat[i][j])
        		j++;
        	else if(x < mat[i][j])
        		i--;
        	else{
        		return true;
        	}
        }
    	return false;
    }
}
