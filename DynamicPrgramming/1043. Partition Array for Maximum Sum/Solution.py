class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        N=len(A)
        dp=[0]*N
        for i in range(N):
            curMax=0
            for k in range(1, K+1):
                if i-k+1<0:
                    break
                curMax=max(curMax, A[i-k+1])
                dp[i]=max(dp[i], (dp[i-k] if i>=k else 0)+curMax*k)
        return dp[N-1]