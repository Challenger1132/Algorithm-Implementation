package newcode;
import java.util.Scanner;
/* 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK
 * */
public class Chorus {
	public static int arrange(int[] arr){
		int[] indexUp = new int[arr.length];
		int[] indexDown = new int[arr.length];
		for (int i = 0; i < indexUp.length; i++){
			indexUp[i] = 1;
			indexDown[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) 
				if(arr[j] < arr[i] && indexUp[i] < indexUp[j] + 1)
					indexUp[i] = indexUp[j] + 1;
		} //递增序列计数	
		for (int i = arr.length-2; i >= 0; i--) {
			for (int j = i+1; j < arr.length; j++) 
				if(arr[j] < arr[i] && indexDown[i] < indexDown[j] + 1)
					indexDown[i] = indexDown[j] + 1;
		} //递减序列计数

		int maxCount = 0;
		for (int i = 0; i < indexDown.length; i++) 
			if(maxCount < indexUp[i] + indexDown[i])
				maxCount = indexUp[i] + indexDown[i];
		
			
		return arr.length - maxCount + 1;  //自己在递增和递减中被重复计算
	}
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int cnt = in.nextInt();
			int[] arr = new int[cnt];
			for (int i = 0; i < cnt; i++) 
				arr[i] = in.nextInt();
			int result = arrange(arr);
			System.out.println(result);
		}
		in.close();
	}
}
