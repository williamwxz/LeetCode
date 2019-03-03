class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        N=len(A)
        left, res=0,0
        for i in range(N):
            K-=(A[i]==0)
            while K<0:
                K+=(A[left]==0)
                left+=1
            res=max(i-left+1, res)
        return res