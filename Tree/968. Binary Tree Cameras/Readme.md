# 968. Binary Tree Cameras

Difficulty: 4.0

If using greedy approach, the most tricky part is, where to put the camera?
Put on the leaf's parent node, think about this, 
If you put camera on leaf: you can cover max **two nodes**
If you put camera on leaf'parent: you can cover max **four nodes**
If you put camera on root, you can cover max **three nodes**

Let's define states of each nodes:
0-leaf (which means the node needs to be covered)
1-camera node
2-covered node
