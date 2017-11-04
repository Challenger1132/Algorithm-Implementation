package test_2;

import java.util.LinkedList;
/* 
判断一棵树是不是完全二叉树，采用层序遍历的方式，总体分为当前节点是叶节点的情况，当前节点不是叶节点的情况
	不是叶节点的情况：当前节点有右节点，没有左节点，直接返回false
	左节点不为空添加左节点到栈，右节点不为空，添加右节点到栈，如果右节点为空，那么isLeafNode置为true
	此后的节点必须全部是叶节点才能保证二叉树是完全的
	是叶节点的情况：但此时如果节点有左节点或者有右节点，或者左右两个节点都有，直接返回false
 * */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
    	if(root == null)
    		return true; //空树也是完全二叉树
    	LinkedList<TreeNode> list = new LinkedList<>();  // 实现队列，采用层序遍历方式
    	boolean isLeafNode = false;  //对于整棵树只有一个节点的情况也适应
    	list.add(root);
    	TreeNode curr;
    	while(!list.isEmpty()){
    		curr = list.poll();
    		if(!isLeafNode){  //非叶节点的情况
    			if(curr.left == null && curr.right != null)
    				return false;
    			if(curr.left != null)
    				list.add(curr.left);
    			if(curr.right != null)
    				list.add(curr.right);
    			else
    				isLeafNode = true; //如果右节点为空
    		}
    		else{//叶节点的情况，但此时如果节点有左节点或者有右节点，或者左右两个节点都有(说明不是右节点)，直接返回false
    			if(curr.left != null || curr.right != null)
    				return false;
    		}
    	}
    	return true;
    }
}