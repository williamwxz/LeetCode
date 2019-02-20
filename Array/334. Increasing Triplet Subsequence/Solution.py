class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # similiar to increasing stack approach, but since we only need 3 numbers in the stack, we don't neccessarily to construct a stack
        if len(nums)<3:
            return False
        stack=[sys.maxint, sys.maxint]
        for num in nums:
            if num<=stack[0]:
                stack[0]=num
            elif num<=stack[1]:
                stack[1]=num
            else:
                return True
        return False