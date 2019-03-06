# 416. Partition Equal Subset Sum

Difficulty: 3.0

There are two approach on this question:
## DFS approach
1. create two buckets
2. base case: when all numbers have been used
3. for each number
   1. check if put on ```bucket[i]``` would under the target sum,
   2. if yes, put the number into bucket, recurisily call dfs

## DP approach
basically it is similiar to backnack problem