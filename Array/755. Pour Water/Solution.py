class Solution:
    def pourWater(self, heights: List[int], V: int, K: int) -> List[int]:
        N=len(heights)
        for i in range(V):
            index=K
            for j in range(K-1, -1, -1):
                if heights[j]>heights[index]:
                    break
                elif heights[j]<heights[index]:
                    index=j
            if index!=K:
                heights[index]+=1
                continue
            for j in range(K+1, N):
                if heights[j]>heights[index]:
                    break
                elif heights[j]<heights[index]:
                    index=j
            heights[index]+=1
        return heights