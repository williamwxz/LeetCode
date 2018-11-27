# 45. Jump Game II

Difficulty: 4.0

**Please review this question in the futre**

Similiar idea as Jump Game I, using greedy approach:
1. Keep increasing the maximum reachable index
2. Scan from the beginning, once reach the previous maximum reachable index, try the next maximum reachable index
3. One important note here: **scan until the last second index**, if we are already at the last index, then no need to increment total jumps.
