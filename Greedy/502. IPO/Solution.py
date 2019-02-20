class Solution(object):
    def findMaximizedCapital(self, k, W, Profits, Capital):
        """
        :type k: int
        :type W: int
        :type Profits: List[int]
        :type Capital: List[int]
        :rtype: int
        """
        projects=zip(Profits, Capital)
        n=len(projects)
        heap=[]
        projects=sorted(projects, key=lambda p:p[1])
        res, j=0, 0
        for i in range(k):
            while j<n and projects[j][1]<=W:
                heapq.heappush(heap, -projects[j][0])
                j+=1
            if len(heap)>0:
                W-=heapq.heappop(heap)
        return W