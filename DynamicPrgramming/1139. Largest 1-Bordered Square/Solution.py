class Solution:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        N,M=len(grid),len(grid[0])
        left=[[0 for j in range(M)] for i in range(N)]
        top=[[0 for j in range(M)] for i in range(N)]
        for i in range(N):
            for j in range(M):
                if grid[i][j]:
                    if i>0:
                        top[i][j]=top[i-1][j]+1
                    else:
                        top[i][j]=1
                    if j>0:
                        left[i][j]=left[i][j-1]+1
                    else:
                        left[i][j]=1
        for l in range(min(N,M), 0, -1):
            for i in range(N-l+1):
                for j in range(M-l+1):
                    if min(top[i+l-1][j], left[i][j+l-1],left[i+l-1][j+l-1],top[i+l-1][j+l-1])>=l:
                        return l*l
        return 0