/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class Solution {
	public class LinkedListNode {
		int val;
		LinkedListNode next;
		public LinkedListNode(int val, LinkedListNode n) {
			this.val = val;
			this.next = n;
		}
	}

	public LinkedListNode addlists(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null || l2 == null) return l1 == null? l2 : l1;
		return helper(l1, l2, 0);
	}

	private LinkedListNode helper(LinkedListNode l1, LinkedListNode l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		else if(l1 == null && l2 == null && carry != 0) {
			return new LinkedListNode(carry, null)
		}
		LinkedListNode res = new LinkedListNode(carry, null);
		int val = carry;
		if(l1 != null) val += l1.val;
		if(l2 != null) val += l2.val;
		carry = val / 10;
		int digit = val % 10;
		res.val = digit;
		LinkedListNode next = helper(l1 == null? null : l1.next, 
									 l2 == null? null : l2.next,
									  carry);
		res.next = next;
		return res;
	}
}



public class Solution2 {
	public class LinkedListNode {
		int val;
		LinkedListNode next;
		public LinkedListNode(int val, LinkedListNode n) {
			this.val = val;
			this.next = n;
		}
	}

	public class PartialSum {
		public LinkedListNode node = null;
		public int carry = 0;
	}

	public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null || l2 == null) return l1 == null? l2 : l1;
		int len1 = length(l1);
		int len2 = length(l2);

		if(len1 < len2) {
			l1 = padList(l1, len2 - len1);
		}
		else if(len1 > len2) {
			l2 = padList(l2, len1 - len2);
		}

		PartialSum res = addHelper(l1, l2);
		if(res.carry == 0) return res.node;
		else {
			LinkedListNode head = new LinkedListNode(carry, res.node);
			return head;
		}
	}

	private PartialSum addHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			return new PartialSum();
		}

		PartialSum res = addHelper(l1.next, l2.next);
		int val = res.carry + l1.val + l2.val;
		LinkedListNode prev = new LinkedListNode(0, null);
		prev.val = val % 10;
		prev.next = res.node;

		res.node = prev;
		res.carry = val / 10;
		return res;
	}

	private int length(LinkedListNode l) {
		int length = 0;
		while(l != null) {
			length++;
			l = l.next;
		} 
		return length;
	} 

	private LinkedListNode padList(LinkedListNode l, int k) {
		LinkedListNode node = null;
		for(int i = 0; i < k; i++) {
			node = new LinkedListNode(0, l);
			l = node;
		}
		return node;
	}
}