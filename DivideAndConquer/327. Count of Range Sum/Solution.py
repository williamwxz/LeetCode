class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        prefix=[0]
        for num in nums:
            prefix.append(prefix[-1]+num)
        def divide_conquer(low, high):
            if high-low<=1:
                return 0
            mid=(high+low)/2
            count=divide_conquer(low, mid)+divide_conquer(mid, high)
            i,j=mid,mid
            for left in prefix[low:mid]:
                while i<high and prefix[i]-left<lower:
                    i+=1
                while j<high and prefix[j]-left<=upper:
                    j+=1
                count+=(j-i)
            prefix[low:high]=sorted(prefix[low:high])
            return count
        return divide_conquer(0, len(prefix))