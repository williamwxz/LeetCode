class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        N=len(stones)
        s=sum(stones)
        dp=[0]*(s+1)
        dp[0]=1
        for i in range(N):
            for j in range(len(dp)-1, -1, -1):
                if j-stones[i]>=0:
                    dp[j]|=dp[j-stones[i]]
        res=s+1
        for pos in range(1, s+1):
            if dp[pos] and 2*pos-s>=0:
                res=min(res, 2*pos-s)
        return res