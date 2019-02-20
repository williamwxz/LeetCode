# 327. Count of Range Sum

Difficulty: 5.0

Naive approach:
1. prefix sum, good to learn to create an array of prefix sum with size n+1, so ```sum[j]-sum[i]=#range of sum of [i, j)```
2. for for loop to try every single range, and return the result.