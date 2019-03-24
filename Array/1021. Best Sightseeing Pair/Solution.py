class Solution:
    def maxScoreSightseeingPair(self, A: List[int]) -> int:
        N=len(A)
        res,cur=0,0
        for i in range(N):
            res=max(res, cur+A[i])
            cur=max(A[i], cur)-1
        return res