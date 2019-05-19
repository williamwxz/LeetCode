class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        N=len(stones)
        stones.sort()
        # find the max
        move_to_right=(stones[N-1]-stones[1]-1)-(N-3)
        move_to_left=(stones[N-2]-stones[0]-1)-(N-3)
        high=max(move_to_left, move_to_right)
        low=float('inf')
        i=0
        for j in range(N):
            while stones[j]-stones[i]+1>N:
                i+=1
            if (j-i+1)==N-1 and (stones[j]-stones[i]+1)==N-1:
                # corner case, when only need an endpoint outside of the range
                low=min(low, 2)
            else:
                low=min(low, N-(j-i+1))
        return [low, high]