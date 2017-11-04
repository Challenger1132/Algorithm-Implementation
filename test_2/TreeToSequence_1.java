package test_2;

import java.util.ArrayList;
import java.util.Stack;
import test_2.TreeNode;
/* 二叉树的非递归实现遍历
 * */
public class TreeToSequence_1 {
	public void preOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		/* 将根节点压入栈，如果栈不为空，就弹出栈顶元素记为curr
		 * 右儿子不为空，将右儿子压入栈，左儿子不为空，将左儿子压入栈
		 * */
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		stack.push(curr);
		while(!stack.isEmpty()){  //循环条件是栈不为空， 先放右儿子，再放左儿子
			curr = stack.pop(); // 访问
			arr.add(curr.val);
			if(curr.right != null)  //右儿子不为空，先压入栈
				stack.push(curr.right);
			if(curr.left != null) 	//左儿子不为空，压入栈
				stack.push(curr.left);
		}
	}
	public void inOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		//对于以curr为头结点的整棵树，依次将整棵树左边界压入栈中，即不断令curr = curr.left;
		while(!stack.isEmpty() || curr != null){
			if(curr != null){ //**  if(curr.left != null)
				stack.push(curr);
				curr = curr.left;
			}
			else{  //curr == null
				curr = stack.pop();
				arr.add(curr.val);
				curr = curr.right; //这里不是将curr压入栈，而是继续重复**步骤
				//注意这里curr有可能为null，当curr为null时且栈不为空，可以执行while循环
				//但此时curr.left就不能执行，因为curr是null，抛出NullPointerException
			}
		}
	}
	public void postOrderTraversal(TreeNode root, ArrayList<Integer> arr){
		/* 将根节点压入栈s1，如果过栈不为空，从栈中弹出元素将其放入s2
		 * 如果该节点左右儿子不为空，依次将左右儿子入栈s1，直到栈s1为空
		 * 依次从s2中弹出元素，弹出顺序就是后序遍历的顺序
		 * */
		if(root == null)
			return;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode curr = root;
		s1.push(root);
		while(!s1.isEmpty()){
			curr = s1.pop();
			s2.push(curr);  // 将弹出的节点压入栈s2
			if(curr.left != null)   //左儿子不为空，先压入栈
				s1.push(curr.left);
			if(curr.right != null) //右儿子不为空，压入栈
				s1.push(curr.right);
		}
		while(!s2.isEmpty())  //依次从
			arr.add(s2.pop().val);
	}
	
	public int[][] convert(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        
        preOrderTraversal(root, pre);
        inOrderTraversal(root, in);
        postOrderTraversal(root, post);
        int[][] result = new int[3][pre.size()];
        for (int i = 0; i < pre.size(); i++) {
        	result[0][i] = pre.get(i);
        	result[1][i] = in.get(i);
        	result[2][i] = post.get(i);
		}
        return result;
    }
}
