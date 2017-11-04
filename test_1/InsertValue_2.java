package test_1;

/* [1,3,4,5,7],[1,2,3,4,0],2
 * */ 

import test_1.ListNode;
public class InsertValue_2 {
	public ListNode insert(int[] arr, int[] next, int val) {
		/* ���뷽����������ָ�룬������ָ��ָ���ֵ��С����ָ��ָ���ֵ
		 * ���С��ͷָ��ָ���ֵ����ô�������ֵ����С�ģ����룬����Ϊͷָ��
		 * ������
		 * */
		if(arr.length == 0)
			return new ListNode(val);
		ListNode head = creatList(arr, next);  //���������
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
	
	
	public static ListNode creatList(int[] arr, int[] next){  //���Դ���ֻ��һ���ڵ�����
		/* ��������������Ѿ���������ˣ����Բ��ý����ж�������Сֵ���ĸ�����һ����Ϊ��Сֵ
		 * */
		if(arr.length != next.length || arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode node = head;
		for (int i = 0; i < next.length-1; i++) {  //Ҫ�����Ĵ���
			ListNode newNode = new ListNode(arr[next[i]]);
			node.next = newNode;
			node = newNode;
		}
//		node.next = head;
		return head;
	}
}
