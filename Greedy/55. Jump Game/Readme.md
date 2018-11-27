# 55. Jump Game

Difficulty: 3.5

DP approach:
1. f = new int[n], f[n-1]=true
2. f[i] = any f[i+nums[i]] is true

Slow, especially when the number is large
Time: O(n*k)
Space: O(n)

Greedy approach:
1. From the beginning, keep increasing the maximum reachable index
2. Finally check if the maximum reachable is less the current index, then fail
