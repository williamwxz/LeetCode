# 375. Guess Number Higher or Lower II

Difficulty: 3.5

Very interesting question
the question is looking for the minimum possible of gurantee winning cost, it will be mini-max problem
if we pick a number x, then the cost=x+max(cost[i:x-1], cost[x+1:j])
then for cost[i:j], find the max cost

base case: i<=j, return 0, if only one number pick, then why you pick