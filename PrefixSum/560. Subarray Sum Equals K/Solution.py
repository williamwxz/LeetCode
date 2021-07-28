class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        N=len(nums)
        prev={0: 1}
        count=0
        res=0
        for num in nums:
            count+=num
            if count-k in prev:
                res+=prev[count-k]
            if count not in prev:
                prev[count]=0
            prev[count]+=1
        return res
        