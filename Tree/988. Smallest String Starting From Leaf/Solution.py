# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        path=[]
        res=[chr(ord('z')+1)]
        def dfs(node):
            if not node:
                return
            path.append(chr(ord('a')+node.val))
            if not node.left and not node.right:
                res[0]=min(res[0], ''.join(path[::-1]))
            dfs(node.left)
            dfs(node.right)
            path.pop(-1)
            return
        dfs(root)
        return res[0]