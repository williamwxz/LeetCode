class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], workers: List[int]) -> int:
        N=len(difficulty)
        jobs=sorted(zip(difficulty, profit))
        res=0
        i=0
        best=0
        for worker in sorted(workers):
            while i<N and jobs[i][0]<=worker:
                best=max(best, jobs[i][1])
                i+=1
            res+=best
        return res