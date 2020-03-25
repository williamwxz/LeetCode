class Solution:
    def mergeStones(self, stones: List[int], K: int) -> int:
        N=len(stones)
        if ((N-K)%(K-1)):
            return -1
        prefix=[0]*(N+1)
        for i in range(1, N+1):
            prefix[i]+=prefix[i-1]+stones[i-1]
        memo={}
        def dfs(i, j):
            if (i,j) in memo:
                return memo[(i,j)]
            if j-i+1<K:
                return 0
            res=float('inf')
            for mid in range(i, j, K-1):
                res=min(res, dfs(i, mid)+dfs(mid+1, j))
            if (j-i)%(K-1)==0:
                res+=(prefix[j+1]-prefix[i])
            memo[(i,j)]=res
            return res
        return dfs(0, N-1)
        