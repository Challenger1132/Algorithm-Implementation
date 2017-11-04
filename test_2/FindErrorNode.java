package test_2;

import java.util.ArrayList;

/* 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树
 * 请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前
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
    	/* 中序遍历，将树中节点值放入ArrayList
    	 * */
    	if(root == null)
    		return;
    	findElement(root.left, arr);
    	arr.add(root.val);
    	findElement(root.right, arr);
    }
}