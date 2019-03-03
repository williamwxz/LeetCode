# 1004. Max Consecutive Ones III

Difficulty: 3.0

It should be a simple approach, but I think too much. 

## DP Approach (TLE)
```dp=new int[N+1][K+1]```
```python
if A[i-1]==0:
    dp[i][k]=max(dp[i-1][k-1], dp[i-1][k])
else:
    dp[i][k]=dp[i-1][k]
```
Time: O(n*k)

## Two pointers (AC)
1. use left and right pointers, ```if A[right]==0   K-=1```
2. ```while K<0 if A[left++]==0 K+=1```
3. check the max length in every cycle
