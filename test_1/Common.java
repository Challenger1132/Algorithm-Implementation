package test_1;

import java.util.ArrayList;
import java.util.Arrays;
/* 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分
 * */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null)
    		return null;
    	ArrayList<Integer> list = new ArrayList<>();
    	ListNode l1 = headA, l2 = headB;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val)
    			l1 = l1.next;
    		else if(l1.val > l2.val)
    			l2 = l2.next;
    		else{
    			list.add(l1.val);
    			l1 = l1.next;
    			l2 = l2.next;
    		}
    	}
    	int[] arr = new int[list.size()];
    	for(int i = 0; i < arr.length; i++)
    		arr[i] = list.get(i);
    	Arrays.sort(arr);
    	return arr;
    }
}