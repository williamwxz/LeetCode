# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
1. base case, if null, return true
2. we want next level return if child is same as root
'''
class Solution:
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        self.res=0
        def count(node):
            if node is None:
                return set()
            left = {node.val}|count(node.left)
            right= {node.val}|count(node.right)
            if len(left)==len(right)==1:
                self.res+=1
            return left|right
        count(root)
        return self.res