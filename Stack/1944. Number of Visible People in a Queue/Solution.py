class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        # height, see the number of people on the right! 
        # heights[i] can anyone on the right until heights[i]<=heights[j]
        # [10,6,8,5,11,9]
        # [0, 2]
        # res: [0, 0, 0, 0, 0]
        N=len(heights)
        res=[0]*N
        stack=[]
        for j, height in enumerate(heights):
            while stack and heights[stack[-1]]<=height:
                # cannot see further right, because stack[-1] block all element smaller
                index=stack.pop(-1)
                res[index]+=1 # height[j] is last you can see
            if stack:
                # after pop all elements from stack[-1] to i, now stack[-1] can i
                # you can see anyone on the right
                res[stack[-1]]+=1
            stack.append(j)
        return res
                