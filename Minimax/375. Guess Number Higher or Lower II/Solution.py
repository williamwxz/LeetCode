def getMoneyAmount(self, n: int) -> int:
        dp=[[0 for j in range(n+1)] for i in range(n+1)]
        def mini_max(i, j):
            if j<=i:
                return 0
            if dp[i][j]:
                return dp[i][j]
            cost=float('inf')
            for x in range(i, j+1):
                cur = x+max(mini_max(i, x-1), mini_max(x+1, j))
                cost=min(cost, cur)
            dp[i][j]=cost
            return cost
        return mini_max(1, n)