class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        N=len(nums)
        prefix=[nums[0]]*N
        for i in range(1,N):
            prefix[i]=prefix[i-1]+nums[i]
        left=[0]
        leftMax=prefix[k-1]
        for i in range(1,N-k+1):
            cur=prefix[i+k-1]-prefix[i-1]
            if cur>leftMax:
                leftMax=cur
                left.append(i)
            else:
                left.append(left[-1])
        right=[0]*N
        right[N-k]=N-k
        rightMax=prefix[N-1]-prefix[N-k-1]
        for i in range(N-k-1, -1, -1):
            cur=prefix[i+k-1]-prefix[i-1]
            if cur>rightMax:
                rightMax=cur
                right[i]=i
            else:
                right[i]=right[i+1]
        count=0
        res=[0]*3
        for i in range(k,N-2*k+1):
            l,r=left[i-k],right[i+k]
            leftMax=prefix[l+k-1]-(0 if l==0 else prefix[l-1])
            rightMax=prefix[r+k-1]-(0 if r==0 else prefix[r-1])
            cur=leftMax+rightMax+(prefix[i+k-1]-prefix[i-1])
            if cur>count:
                count=cur
                res=[l,i,r]
        return res