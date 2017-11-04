package hw_1;

import java.util.Scanner;

public class SplitCE {
	public static String solution(String str){
		StringBuilder sb = new StringBuilder();
		boolean isEnglishCharacter = false;
		boolean isChineseCharacter = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch < 255){  // EnglishCharacter
				if(isEnglishCharacter){
					sb.append("<>");
					isEnglishCharacter = false;
				}
				sb.append(ch);
				isChineseCharacter = true;
			}
			else{  // ChineseCharacter
				if(isChineseCharacter){
					sb.append("<>");
					isChineseCharacter = false;
				}
				sb.append(ch);
				isEnglishCharacter = true;
			}
		}
		if(sb.charAt(sb.length()-1) > 255)
			sb.append("<>");
		if(sb.charAt(0) > 255)
			sb.insert(0, "<>");
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			System.out.println(solution(str));
		}
		in.close();
		
	}
}
