package test_2;

import java.util.ArrayList;

/* һ�ö�����ԭ�������������������������������ڵ������λ�ã�ʹ����ö���������������������
 * ���ҵ�����������ڵ㲢�������ǵ�ֵ����֤�������н���ֵ������ͬ
 * ����һ�����ĸ���㣬�뷵������������λ�õ�ֵ������С��ֵ��ǰ
 * */
public class FindErrorNode2 {
    public int[] findError(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<>();
    	ArrayList<Integer> resultArr = new ArrayList<>();
    	findElement(root, arr);
    	int[] result = new int[2];

    	for (int i = 1; i < arr.size(); i++) {
			if(arr.get(i) < arr.get(i-1)){
				resultArr.add(arr.get(i-1));
				resultArr.add(arr.get(i));
			}
		}
    	result[1] = resultArr.get(0);
    	if(resultArr.size() == 4) //���������������½�
    		result[0] = resultArr.get(3);
    	else
    		result[0] = resultArr.get(1);
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