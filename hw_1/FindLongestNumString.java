package hw_1;

import java.util.Scanner;

public class FindLongestNumString {
	public static String longestStr(String str){
		int max = 0;
		int temp = 0;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				temp++;
				if(max <= temp){ // 记录temp的最大值
					max = temp;
					index = i;
				}
			}
			else
				temp = 0;
		}
		return str.substring(index-max+1, index+1);
	}
	
	public static String longestStr2(String str){
		boolean isContainsDigit = false;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				isContainsDigit = true;
				break;
			}
		}
		if(!isContainsDigit)
			return "";
		
		String[] s = str.split("\\D+");  //split
		int maxlength = s[0].length();
		int index = 0;
		for(int i = 1;i < s.length; i++){
			if(maxlength <= s[i].length()){
				maxlength = s[i].length();
				index = i;
			}
		}
		return s[index];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			String result = longestStr(str);
			System.out.println(result);
		}
		in.close();
	}
}
