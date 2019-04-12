class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # dp[i][j] - first ith element to get j ammount
        # dp[i][j]=dp[i-1][j]+dp[i][j-coin]
        N=len(coins)
        dp=[[0 for j in range(amount+1)] for i in range(N+1)]
        dp[0][0]=1
        for i in range(1, N+1):
            for j in range(0, amount+1):
                dp[i][j]=dp[i-1][j]
                if j>=coins[i-1]:
                    dp[i][j]+=dp[i][j-coins[i-1]]
        return dp[N][amount]