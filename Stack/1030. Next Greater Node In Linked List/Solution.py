# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        stack=collections.deque()
        res=[]
        while head:
            res.append(head.val)
            head=head.next
        for i in range(len(res)):
            while stack and res[stack[-1]]<res[i]:
                res[stack.pop()]=res[i]
            stack.append(i)
        while stack:
            res[stack.pop()]=0
        return res