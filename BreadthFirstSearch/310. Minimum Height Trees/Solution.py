import collections
class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n==1:
            return [0]
        elif n==2:
            return [0,1]
        graph=[]
        indegrees=[]
        for i in range(n):
            graph.append([])
            indegrees.append(0)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
            indegrees[edge[0]]+=1
            indegrees[edge[1]]+=1
        queue = collections.deque()
        for i in range(n):
            if indegrees[i]==1:
                queue.append(i)
        while n>2:
            size = len(queue)
            n-=size
            for i in range(size):
                cur = queue.popleft()
                for p in graph[cur]:
                    if indegrees[p]==0:
                        continue
                    indegrees[p]-=1
                    if indegrees[p]==1:
                        queue.append(p)
        result = list(queue)
        return result
                
