package test_2;

import java.util.ArrayList;
import java.util.LinkedList;
/* ���Ĳ�α��������������
 * last�ǵ�ǰ����� ��һ���ڵ�
 * nlast����һ�������һ���ڵ� ,�����ǰ�ڵ����last˵�����˸ò�����ҵĽڵ㣬���л��в���
 * ����last = nlast��ÿ����һ���ڵ㣬����һ���жϣ����������last�ͽ������ͬһ��ArrayList�У�
 * ÿ�λ���ͬʱ����µ�ArrayList
 * */
public class TreeLevelPrinter {
	public int[][] printTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode last = root, nlast = root;
		LinkedList<TreeNode> list = new LinkedList<>();  //���й���
		ArrayList<TreeNode> arr = new ArrayList<>();
		ArrayList<ArrayList<TreeNode>> arrs = new ArrayList<>();
		TreeNode tmp;
		
		list.addLast(root);
		while(!list.isEmpty()){
			tmp = list.removeFirst();  //����
			arr.add(tmp);
			if(tmp.left != null){ //��ڵ㲻Ϊnull������ڵ���ӣ��Ҹ���nlast
				nlast = tmp.left;
				list.addLast(tmp.left);
			}
			if(tmp.right != null){
				nlast = tmp.right;
				list.addLast(tmp.right);
			}
			if(tmp == last){
				last = nlast;
				arrs.add(arr);
				arr = new ArrayList<>();
			}
		}
		int[][] val = new int[arrs.size()][];
		for(int i = 0;i < arrs.size(); i++){
			ArrayList<TreeNode> tmpList = arrs.get(i);
			val[i] = new int[tmpList.size()];
			for (int j = 0; j < tmpList.size(); j++)
				val[i][j] = tmpList.get(j).val;
		}
		return val;
	}
}