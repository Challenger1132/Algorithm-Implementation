package test_1;

/* [1,3,4,5,7],[1,2,3,4,0],2
 * */ 

import test_1.ListNode;
public class InsertValue_2 {
	public ListNode insert(int[] arr, int[] next, int val) {
		/* 插入方法不用两个指针，大于左指针指向的值，小于右指针指向的值
		 * 如果小于头指针指向的值，那么被插入的值是最小的，插入，且置为头指针
		 * 否则找
		 * */
		if(arr.length == 0)
			return new ListNode(val);
		ListNode head = creatList(arr, next);  //构造的链表
		ListNode insert = new ListNode(val);
//		ListNode tail = head;
//		for(int i = 0;i < arr.length-1; i++)
//			tail = tail.next;
		if(val < head.val){
			insert.next = head;
			return insert;
		}
		ListNode first = head, second = first.next;
		while(second != null && val > second.val){
			first = second;
			second = first.next;
		}
		first.next = insert;
		insert.next = second;
		return head;
    }
	
	
	public static ListNode creatList(int[] arr, int[] next){  //可以处理只有一个节点的情况
		/* 这里给出的数据已经是有序的了，所以不用进行判断链表最小值是哪个，第一个即为最小值
		 * */
		if(arr.length != next.length || arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode node = head;
		for (int i = 0; i < next.length-1; i++) {  //要操作的次数
			ListNode newNode = new ListNode(arr[next[i]]);
			node.next = newNode;
			node = newNode;
		}
//		node.next = head;
		return head;
	}
}
