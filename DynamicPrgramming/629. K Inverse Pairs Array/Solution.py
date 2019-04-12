class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        dp=[0 for i in range(k+1)]
        dp[0]=1
        MOD=10**9+7
        for i in range(1, n+1):
            for j in range(1, k+1):
                dp[j]+=dp[j-1]
            for j in range(k, 0, -1):
                if i>j:
                    break
                dp[j]-= dp[j-i]
        return dp[k]%MOD