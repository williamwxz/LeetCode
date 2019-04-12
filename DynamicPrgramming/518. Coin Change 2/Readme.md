# 518. Coin Change 2

Difficulty: 3.5

Classic knack problem
```dp[i][j] - number of ways from first ith element to construct j amount```
```dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]```
```dp[i-1][j] --- use i-1 th element to construct j amount```
```dp[i][j-coins[i-1]] --- INCLUDE the current ith element to construct j-coins[i-1] amount```