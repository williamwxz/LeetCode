# 962. Maximum Width Ramp

Difficulty: 3.5

A little bit greedy approach, for each number in the array, we need to know the smaller numbers with smallest index.
Looks like we will need a stack to solve it.

Initially I was trying to using increasing stack to do, but it won't work.

The correct approach is to use decreasing stack
1. Put all number into decreasing stack
2. loop number from the back, ```if A[i]>=A[stack.peekLast()]```, keep pop from the end, and update the max.
