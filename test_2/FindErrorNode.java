package test_2;

import java.util.ArrayList;

/* һ�ö�����ԭ�������������������������������ڵ������λ�ã�ʹ����ö���������������������
 * ���ҵ�����������ڵ㲢�������ǵ�ֵ����֤�������н���ֵ������ͬ
 * ����һ�����ĸ���㣬�뷵������������λ�õ�ֵ������С��ֵ��ǰ
 * */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<>();
    	findElement(root, arr);
    	int[] result = new int[2];
    	boolean onceOnly = true;
    	for (int i = 1; i < arr.size(); i++) {
			if(onceOnly){
				if(arr.get(i) < arr.get(i-1)){
					result[1] = arr.get(i-1);
					result[0] = arr.get(i);
					onceOnly = false;
				}
			}
			else{
				if(arr.get(i) < arr.get(i-1))
					result[0] = arr.get(i);
			}
		}
    	return result;
    }
    public static void findElement(TreeNode root, ArrayList<Integer> arr) {
    	/* ��������������нڵ�ֵ����ArrayList
    	 * */
    	if(root == null)
    		return;
    	findElement(root.left, arr);
    	arr.add(root.val);
    	findElement(root.right, arr);
    }
}