package hw_1;

import java.util.ArrayList;
import java.util.Scanner;
/* ÿ��ֻ��ɾ��һ�������ţ�ÿ��ɾ������һ��������
 * ��������ַ���ɾ�ɿմ������з��� 
 * */
public class Brackets {
	public static void ways(String str){
		ArrayList<Integer> arr = new ArrayList<>();
		int cnt = 0;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == '(')
				cnt++;
			else{
				arr.add(cnt);
				cnt = 0;
			}
		}
		int result = 1;
		for (int i = 0; i < arr.size(); i++) 
			result *= factorial(arr.get(i));
		System.out.println(result);
	}
	private static int factorial(int n){   //����n!
		int result = 1;
		for (int i = 2; i <= n; i++) 
			result *= i;
		return result;
	}
	/*****************************************************************/
	
	public static void ways2(String str){
		int cnt = 0;
		int result = 1;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == '(')
				cnt++;
			else{
				result *= cnt;
				cnt--;
			}
		}
		System.out.println(result);
	}
	

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			ways2(str);
		}
		in.close();
	}
}
