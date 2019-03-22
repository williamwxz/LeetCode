class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        N = len(nums)
        if N<2:
            return N
        inc, dec=1,1
        for i in range(1, N):
            if nums[i]>nums[i-1]:
                inc = dec+1
            elif nums[i]<nums[i-1]:
                dec = inc+1
        return max(inc, dec)