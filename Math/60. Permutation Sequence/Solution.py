class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        nums=[i for i in range(1, n+1)]
        factorial=[1]
        for i in range(1, n+1):
            factorial.append(factorial[-1]*(i))
        res=[]
        k-=1
        while n>0:
            index=k//factorial[n-1]
            res.append(str(nums[index]))
            del nums[index]
            k%=factorial[n-1]
            n-=1
        return "".join(res)