package hw;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GridStep {
	public static void countStep(int[][] maze){
		int xlen = maze.length, ylen = maze[0].length;
		LinkedList<Node> queue = new LinkedList<>();
		Node firstNode = new Node(0, 0, null);
		queue.add(firstNode);
		Node curr;
		int totalPaths = 0;
		while(!queue.isEmpty()){
			curr = queue.poll();
			if(curr.x == xlen-1 && curr.y == ylen-1){
				totalPaths++;
				printPaths(curr);
			}
			if(curr.x+1 < xlen)
				queue.add(new Node(curr.x+1, curr.y, curr));
			if(curr.y+1 < ylen)
				queue.add(new Node(curr.x, curr.y+1, curr));
		}
		System.out.println(totalPaths);
	}
	public static void printPaths(Node curr){
		Stack<Node> stack = new Stack<>();
		stack.push(curr);
		while(curr.pre != null){
			curr = curr.pre;
			stack.push(curr);
		}
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int lenx = in.nextInt();
			int leny = in.nextInt();
			int[][] maze = new int[lenx+1][leny+1];
			countStep(maze);
		}
		in.close();
	}
}
class Node{
	int x;
	int y;
	Node pre;
	public Node(int x, int y, Node pre){
		this.x = x;
		this.y = y;
		this.pre = pre;
	}
	@Override
	public String toString() {
		return x + ", " + y;
	}
}