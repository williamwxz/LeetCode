class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        N=len(nums)
        target=sum(nums)//2
        if target*2!=sum(nums):
            return False
        nums=sorted(nums)[::-1]
        bag=[0]*2
        def dfs(index):
            if index==N:
                return (bag[0]==bag[1])
            for i in range(2):
                if bag[i]+nums[index]<=target:
                    bag[i]+=nums[index]
                    if dfs(index+1):
                        return True
                    bag[i]-=nums[index]
            return False
        return dfs(0)