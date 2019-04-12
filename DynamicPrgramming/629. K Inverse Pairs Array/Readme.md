# 629. K Inverse Pairs Array

Difficulty: 4.5

For example:
xxxx5  generate 0 pair  => ```dp[n][k]=dp[n-1][k]```, we still want the previous case have k pairs
xxx5x  generate 1 pair  => ```dp[n][k]=dp[n-1][k-1]```, we still want the previous case have k-1 pairs
xx5xx  generate 2 pairs => ```dp[n][k]=dp[n-1][k-2]```, we still want the previous case have k-2 pairs
x5xxx  generate 3 pairs => ```dp[n][k]=dp[n-1][k-3]```, we still want the previous case have k-3 pairs
5xxxx  generate 4 pairs => ```dp[n][k]=dp[n-1][k-4]```, we still want the previous case have k-4 pairs

So
```dp[n][k]=sum(dp[n-1][k-j]) where 0<=j<n``` 
Time: O(n*k*j)

To optimize it:
```dp[n][k]=dp[n-1][k]+dp[n][k-1]-dp[n-1][k-n] if k>=n else 0```
Time: O(n*k)
Space: O(n*k)
[Reference](http://www.cnblogs.com/grandyang/p/7111385.html)

Further space optmization:
See the answer
Space: O(k)