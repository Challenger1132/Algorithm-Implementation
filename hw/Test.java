package hw;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
	static String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Zero"};
	static String[] pinyins = {"Yi", "Er", "San", "Si", "Wu", "Liu", "Qi", "Ba", "Jiu", "Ling"};
	
	public static void convert(String input){
		for(int i = 0; i < words.length; i++){
			if(input.contains(pinyins[i])){
				pinyinToEnglish(input);
				break;
			}
			else if(input.contains(words[i])){
				englishToPinyin(input);
				break;
			}
			else
				System.out.println("ERROR");
		}
	}
	public static void pinyinToEnglish(String input){
		StringBuilder sb = new StringBuilder();
		String[] inputPinyin = input.split("\\s");
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) 
			map.put(pinyins[i], words[i]);
		for (int i = 0; i < inputPinyin.length; i++) 
			sb.append(map.get(inputPinyin[i]));
		System.out.println(sb.toString());
	}
	public static void englishToPinyin(String input){
		StringBuilder sb = new StringBuilder();
		String[] inputEnglish = input.split("\\s");
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) 
			map.put(words[i], pinyins[i]);
		String temp = "";
		for (int i = 0; i < inputEnglish.length-1; i++){
			temp = inputEnglish[i+1];
			String english = map.get(inputEnglish[i]);
			if(english == "Double"){
				sb.append(temp + " " + temp);
			}
			else{
				sb.append(map.get(english));
			}
		}
		sb.append(inputEnglish[inputEnglish.length-1]);
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			convert(str);
		}
		in.close();
	}
}
