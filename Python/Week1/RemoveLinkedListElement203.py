# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if head == None:
            return None

        dummy = ListNode(0)
        dummy.next = head

        pre = dummy
        cur = head
        while cur != None:
            if cur.val == val:
                next = cur.next
                cur.next = None
                pre.next = next
                cur = next
            else:
                pre = pre.next
                cur = cur.next
        return dummy.next
