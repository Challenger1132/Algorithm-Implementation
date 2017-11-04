package test_2;

import java.util.ArrayList;
import java.util.LinkedList;
/* 树的层次遍历，且输出换行
 * last是当前层的最 右一个节点
 * nlast是下一层的最右一个节点 ,如果当前节点等于last说明到了该层的最右的节点，进行换行操作
 * 且令last = nlast，每出队一个节点，进行一次判断，如果不等于last就将其放入同一个ArrayList中，
 * 每次换行同时造出新的ArrayList
 * */
public class TreeLevelPrinter {
	public int[][] printTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode last = root, nlast = root;
		LinkedList<TreeNode> list = new LinkedList<>();  //队列功能
		ArrayList<TreeNode> arr = new ArrayList<>();
		ArrayList<ArrayList<TreeNode>> arrs = new ArrayList<>();
		TreeNode tmp;
		
		list.addLast(root);
		while(!list.isEmpty()){
			tmp = list.removeFirst();  //出队
			arr.add(tmp);
			if(tmp.left != null){ //左节点不为null，将左节点入队，且更新nlast
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