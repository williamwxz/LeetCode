class Solution:
    # Math question: combinations
    def countCornerRectangles(self, grid: List[List[int]]) -> int:
        N,M=len(grid),len(grid[0])
        res=0
        for i in range(N):
            for j in range(i+1, N):
                count=0
                for k in range(M):
                    if grid[i][k] and grid[j][k]:
                        count+=1
                if count:
                    res+=count*(count-1)//2
        return res