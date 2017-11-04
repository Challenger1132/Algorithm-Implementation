package test_2;
/* 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，
 * 这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次
 * 请从上到下计算出所有折痕的⽅向
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/* 折痕的计算总体是一个中序遍历，折痕可以形成一个满二叉的形状，(考虑两次折叠形成的，采用中序遍历的情况)
 * true代表上折痕，false代表下折痕
 * */
public class FoldPaper {
    public static String[] foldPaper(int n) {
    	ArrayList<String> arr = new ArrayList<>();
    	fold(1, n, false, arr);
    	String[] result = arr.toArray(new String[arr.size()]);
    	return result;
    }
    public static void fold(int layer, int maxLayer, boolean flag, ArrayList<String> arr){
    	/* layer折叠次数
    	 * maxLayer代表最大折叠次数
    	 * 
    	 * */
    	if(layer > maxLayer)  // 超过最大折叠次数
    		return;
    	fold(layer+1, maxLayer, false, arr);
    	arr.add(flag ? "up" : "down");
    	fold(layer+1, maxLayer, true, arr);
    }
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			String[] result = foldPaper(n);
			System.out.println(Arrays.toString(result));
		}
		in.close();
	}
}
