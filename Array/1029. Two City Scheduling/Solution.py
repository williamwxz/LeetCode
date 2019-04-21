class Solution:
    # divide all peole in to 2 groups with LOWEST cost
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        N=len(costs)
        costs.sort(key=lambda x:x[0]-x[1])
        res=0
        for cost in costs[:N//2]:
            res+=cost[0]
        for cost in costs[N//2::]:
            res+=cost[1]
        return res