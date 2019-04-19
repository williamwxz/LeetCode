class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        left,right=max(weights),sum(weights)
        while left<right:
            mid,bag,cur=left+(right-left)//2, 0, 0
            for w in weights:
                if cur+w>mid:
                    bag+=1
                    cur=0
                cur+=w
            if bag>=D:
                left=mid+1
            else:
                right=mid
        return left