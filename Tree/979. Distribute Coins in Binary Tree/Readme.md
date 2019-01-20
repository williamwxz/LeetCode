# 979. Distribute Coins in Binary Tree

Difficulty: 4.0

The idea behind is very simple, but I wasn't able to figure it out

base case, if root==null, return 0
when parent node want? return positive number for have some coins remain, negative for needed coins
in the current level, get the coins from left and right, compute the number of coins remain after the current level
for example, left=-2, right=1, left subtree need 2 coins, which means, we must pass 2 into left substree, so result+=2,
and right has extra 1 coin, we must pass 1 into right substree, so result+=1


1. Base case
2. What does the previous level **want**???
3. What is the return?