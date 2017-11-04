package newcode;
import java.util.Scanner;
/* �ϳ�������ָ������һ�ֶ��Σ���Kλͬѧ���������α��Ϊ1��2����K�����ǵ���߷ֱ�ΪT1��T2������TK
 * �����ǵ�����������i��1<=i<=K��ʹ��T1<T2<......<Ti-1<Ti>Ti+1>......>TK
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
		} //�������м���	
		for (int i = arr.length-2; i >= 0; i--) {
			for (int j = i+1; j < arr.length; j++) 
				if(arr[j] < arr[i] && indexDown[i] < indexDown[j] + 1)
					indexDown[i] = indexDown[j] + 1;
		} //�ݼ����м���

		int maxCount = 0;
		for (int i = 0; i < indexDown.length; i++) 
			if(maxCount < indexUp[i] + indexDown[i])
				maxCount = indexUp[i] + indexDown[i];
		
			
		return arr.length - maxCount + 1;  //�Լ��ڵ����͵ݼ��б��ظ�����
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
