package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TwoStack_1 {
	public static int[] twoStacksSort(int[] arr) {
		Stack<Integer> helper = new Stack<>();
		for(int i = 0;i < arr.length; i++){
			int curr = arr[i]; //当前元素
			if(helper.isEmpty())
				helper.push(curr);
			else{
				int peek = helper.peek();
				if(curr <= peek)
					helper.push(curr);
				else{
					int j = i;
					while(true){
						arr[j--] = helper.pop();//index i的位置被栈中元素占据，因此**要重新拷贝到辅助栈里面
						if(helper.isEmpty() || curr <= helper.peek())  
						// 辅助栈为或者当前元素小于等于辅助栈栈顶元素，结束循环
							break;
					}
					helper.push(curr);
					j = j + 1;
					while(i != j)
						helper.push(arr[j++]);
					helper.push(arr[i]);  //**
				}
			}
		}
		int n = arr.length-1;
		while(!helper.isEmpty()){
			arr[n] = helper.pop();
			n--;
		}
		return arr;
    }
	public static ArrayList<Integer> twoStacksSort_1(int[] arr) {
		int[] helper = new int[arr.length];
		int index = arr.length - 1;;
		for(int i = 0;i < arr.length; i++){
			int curr = arr[i]; //当前元素
			if(index == arr.length-1){
				helper[index] = curr;
				index--;
			}
			else{
				int peek = helper[index+1];  //index-1的位置指向的就是栈顶的元素
				if(curr <= peek){
					helper[index] = curr;
					index--;
				}
				else{
					int j = i;
					while(curr > peek){
						arr[j--] = peek;
						index++;
						if(index >= arr.length-1)
							break;
						peek = helper[index+1];
					}
					helper[index] = curr;
					index--;
					j = j + 1;
					while(i != j){
						helper[index] = arr[j++];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
						index--;
					}
					helper[index] = arr[i];
					index--;
				}
			}
		}
		ArrayList<Integer> alist = new ArrayList<>();
		for (int i = 0; i < helper.length; i++) 
			alist.add(helper[helper.length - 1 -i]);
		return alist;
    }
	public static void main(String[] args) {
		int[] arr = {1,3,65,55,4,33,33,2,7,4,9,0};
		System.out.println(Arrays.toString(arr));
		int[] sort = twoStacksSort(arr);
		System.out.println(Arrays.toString(sort));
	}
}
