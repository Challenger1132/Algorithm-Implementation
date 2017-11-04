package test_2;

import java.util.ArrayList;

public class TreeToSequence {
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
    public static void preOrderTraversal(TreeNode root, ArrayList<Integer> list){
    	if(root != null){
    		list.add(root.val);
    		preOrderTraversal(root.left, list);
    		preOrderTraversal(root.right, list);
    	}
    }
    public static void inOrderTraversal(TreeNode root, ArrayList<Integer> list){
    	if(root != null){
    		inOrderTraversal(root.left, list);
    		list.add(root.val);
    		inOrderTraversal(root.right, list);
    	}
    }
    public static void postOrderTraversal(TreeNode root, ArrayList<Integer> list){
    	if(root != null){
    		postOrderTraversal(root.left, list);
    		postOrderTraversal(root.right, list);
    		list.add(root.val);
    	}
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}