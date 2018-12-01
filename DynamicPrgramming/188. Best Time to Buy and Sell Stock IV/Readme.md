# 188. Best Time to Buy and Sell Stock IV

Difficulty: 4.5

Classic DP+state problem:
Generic Template
For 2 transactions, there will be 5 states:
1. No buy yet
2. First buy
3. First sell
4. Second buy
5. Second sell

The result will come from either of the states. 

For k transactions, there will be 2*k+1 states.
dp[i][j] --- first i days, at j state.
dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]-prices[i-1]) if i is odd and dp[i-1][j-1] can be reached (not Integer.MIN_VALUE)
                stay        move from sell state, buy stock
OR
dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]+prices[i-1]) if i is even and dp[i-1][j-1] can be reached (not Integer.MIN_VALUE)
                stay        move from buy state, sell stock

## Note:
if k is too large, larger than n,
then means we can do many transactions, just use Stock II solution. 
