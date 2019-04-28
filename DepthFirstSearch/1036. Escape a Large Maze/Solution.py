class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        N=len(blocked)
        if N<=1:
            return True
        wall=set(map(tuple, blocked))
        directions=[[-1,0],[0,1],[1,0],[0,-1]]
        visited=set()
        BOUND=12739
        AREA=10**6
        def dfs(r, c, dest, step=0):
            if r<0 or r>=AREA or c<0 or c>= AREA or (r,c) in visited or (r,c) in wall:
                return False
            visited.add((r,c))
            if step>=BOUND or [r,c]==dest:
                return True
            return dfs(r-1, c, dest, step+1) or dfs(r, c+1, dest, step+1) or dfs(r+1, c, dest, step+1) or dfs(r, c-1, dest, step+1)
        return dfs(source[0], source[1], target) and dfs(target[0], target[1], source)
