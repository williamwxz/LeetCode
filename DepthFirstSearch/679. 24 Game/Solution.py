class Solution:
    def judgePoint24(self, nums: List[int]) -> bool:
        N=len(nums)
        if N==1:
            return math.isclose(nums[0], 24)
        for i in range(N):
            for j in range(i+1, N):
                tmp=[]
                for k in range(N):
                    if k!=i and k!=j:
                        tmp.append(nums[k])
                tmp.append(-1)
                #add and multiplication do not need to do twice
                tmp[-1]=nums[i]+nums[j]
                if self.judgePoint24(tmp):
                    return True
                tmp[-1]=nums[i]*nums[j]
                if self.judgePoint24(tmp):
                    return True
                tmp[-1]=nums[i]-nums[j]
                if self.judgePoint24(tmp):
                    return True
                tmp[-1]=nums[j]-nums[i]
                if self.judgePoint24(tmp):
                    return True
                if nums[j]!=0:
                    tmp[-1]=nums[i]/nums[j]
                    if self.judgePoint24(tmp):
                        return True
                if nums[i]!=0:
                    tmp[-1]=nums[j]/nums[i]
                    if self.judgePoint24(tmp):
                        return True
        return False
                        