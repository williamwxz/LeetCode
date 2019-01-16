# 958. Check Completeness of a Binary Tree

Difficulty: 2.5

bfs approach is an obvious solution, but found an interesting approach.
1. using bfs to put all nodes into a queue
2. and then loop the queue, stop when find a null
3. check if there still anything in the queue, if yes, then it is not complete tree, if not, then it is a complete tree.