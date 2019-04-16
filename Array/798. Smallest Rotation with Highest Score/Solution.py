class Solution:
    def bestRotation(self, A: List[int]) -> int:
        N=len(A)
        interval=[0]*N
        for i in range(N):
            left=(i+1)%N
            right=(i-A[i]+1)%N
            interval[left]+=1
            interval[right]-=1
            if left>right:
                interval[0]+=1
        res, maxK=0, -1
        for i in range(N):
            interval[i]+= interval[i-1] if i>0 else 0
            if interval[i]>maxK:
                res=i
                maxK=interval[i]
        return res