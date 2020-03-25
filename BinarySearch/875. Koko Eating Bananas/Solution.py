class Solution:
    def minEatingSpeed(self, piles: List[int], H: int) -> int:
        low, high = 1, max(piles)
        
        def rounds(K):
            count=0
            for pile in piles:
                count+=(pile//K)
                if pile%K!=0:
                    count+=1
            return count
        
        while low<=high:
            K = low+(high-low)//2
            if rounds(K)<=H:
                high=K-1
            else:
                low=K+1
        return low
        