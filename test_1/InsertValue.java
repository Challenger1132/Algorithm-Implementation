package test_1;

/* [1,3,4,5,7],[1,2,3,4,0],2
 * */
public class InsertValue {
	public ListNode insert(int[] arr, int[] next, int val) {
		ListNode head = creatList(arr, next);
		ListNode first = head, second = first.next;
		ListNode tail = head;
		ListNode insert = new ListNode(val);
		for(int i = 0;i < arr.length-1; i++)
			tail = tail.next;
		if(val >= tail.val){
			tail.next = insert;
			insert.next = head;
		}
		else if(val <= head.val){
			tail.next = insert;
			insert.next = head;
			head = insert;
		}
		else{
			while(true){
				if(val > first.val && val < second.val){
					first.next = insert;
					insert.next = second;
					break;
				}
				first = first.next;
				second = second.next;
			}
		}
		return head;
    }
	
	
	public static ListNode creatList(int[] arr, int[] next){  //���Դ���ֻ��һ���ڵ�����
		/* ��������������Ѿ���������ˣ����Բ��ý����ж�������Сֵ���ĸ�����һ����Ϊ��Сֵ
		 * */
		if(arr.length != next.length || arr.length == 0)
			return null;
		ListNode head = null;
		int nex = 0;
		ListNode firstNode = new ListNode(arr[0]);
		int min = firstNode.val;
		ListNode node = firstNode;
		head = firstNode;
		for (int i = 0; i < next.length-1; i++) {
			nex = next[i];
			ListNode newNode = new ListNode(arr[nex]);
			if(min > newNode.val)
				head = newNode;
			node.next = newNode;
			node = newNode;
		}
		node.next = firstNode;
		return head;
	}
}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}