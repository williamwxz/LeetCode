# 689. Maximum Sum of 3 Non-Overlapping Subarrays

This is a non-classic DP question, with greedy approach.

Since we only need **THREE** subarray, so we can use middle one as the center.
Create an array called left, which record the first index of subarray that is the largest sum from the left
Create an array called right, same thing but from the right.

Now for loop from index k to index (n-2*k), use i as the first index of subarray as the middle subarray, use it to compute subarray sum.
Get the largest sum from left, largest sum from the right, and the middle subarray sum, find the largest sum.

In this case, there are many finding subarray sum operation, so we can use **prefix sum** to get subarray sum in O(1) time

