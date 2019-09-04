class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        N=len(arr)
        res=0
        curMax=0
        for i,num in enumerate(arr):
            curMax=max(curMax, num)
            if curMax==i:
                res+=1
        return res