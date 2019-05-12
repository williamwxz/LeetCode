class Solution:
    def gardenNoAdj(self, N: int, paths: List[List[int]]) -> List[int]:
        graph=[[] for i in range(N)]
        for path in paths:
            graph[path[0]-1].append(path[1]-1)
            graph[path[1]-1].append(path[0]-1)
        res=[0]*N
        for i in range(N):
            res[i]=({1,2,3,4}-{res[j] for j in graph[i]}).pop()
        return res