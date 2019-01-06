# 971. Flip Binary Tree To Match Preorder Traversal

Difficulty: 3.5

Preorder traverse on an array, also keep in mind that whenever swapping two nodes, their subtree also be swapped.

Few logic:
1. ```if root.val!=voyage[cur]: return False```
2. if the current left node does not match voyage[cur], then also check if the right node match the voyage[cur], if yes, then swap then
3. check their child node
