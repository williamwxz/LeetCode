class Solution:
    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        # BFS + heap 
        N,M=len(grid),len(grid[0])
        queue=[(-grid[0][0], 0, 0)] #(cur max, i, j)
        DIRS=[(-1,0),(0,1),(1,0),(0,-1)]
        res=10**9+1
        while queue:
            val, i, j=heapq.heappop(queue)
            val=-val # reverse for actual value
            res=min(res, val)
            if i==N-1 and j==M-1:
                break
            for d in DIRS:
                x,y=i+d[0],j+d[1]
                if 0<=x<N and 0<=y<M and grid[x][y]>=0:
                    heapq.heappush(queue, (-grid[x][y], x, y))
                    grid[x][y]=-1
        return res
                