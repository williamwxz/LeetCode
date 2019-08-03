class Solution:
    #found the min value the next player can get, then use the remaining sum - the min value = max
    def stoneGameII(self, piles: List[int]) -> int:
        N=len(piles)
        memo={}
        count=[0]*N
        count[N-1]=piles[N-1]
        for i in range(N-2, -1, -1):
            count[i]=count[i+1]+piles[i]
        def dfs(i, M):
            if i>=N:
                return 0
            if i+2*M>=N:
                #it can take all the remaining stones, that means we can get the maximum value here
                return count[i]
            if (i,M) in memo:
                return memo[(i,M)]
            res=float('inf')
            for x in range(1, 2*M+1):
                res=min(res, dfs(i+x, max(x,M)))
            memo[(i,M)]=count[i]-res
            return memo[(i,M)]
        return dfs(0, 1)