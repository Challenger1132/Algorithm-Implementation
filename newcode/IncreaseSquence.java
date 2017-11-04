package newcode;
/* ����һ������ÿ��Ԫ�صĵ���������Ҳ���Ǵ������һ��Ԫ�ص���ǰԪ���ж��ٸ�Ԫ�ؿ���ά�ֵ�������
186	186	150	200	160	130	197	200
1	1	1	2	2	1	3	4	��������
 * */
import java.util.Arrays;

public class IncreaseSquence {
	public static int[] increaseIndex(int[] arr){
		int[] indexUp = new int[arr.length];
		for (int i = 0; i < indexUp.length; i++)
			indexUp[i] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] < arr[i] && indexUp[j]+1 > indexUp[i])
					indexUp[i] = indexUp[j]+1;
			}
		}
		return indexUp;
	}
	public static void main(String[] args) {
		int[] test = new int[]{186,186,150 ,200 , 160 , 130 , 197 , 200};
		int[] testR = new int[test.length];
		for (int i = 0; i < testR.length; i++)
			testR[i] = test[testR.length-1-i];
		
		int[] indexUp = increaseIndex(test);
		int[] indexDown = increaseIndex(testR);
		System.out.println(Arrays.toString(indexUp));
		System.out.println(Arrays.toString(indexDown));
	}
}
