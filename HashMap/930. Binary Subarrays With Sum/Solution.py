class Solution(object):
    def numSubarraysWithSum(self, A, S):
        """
        :type A: List[int]
        :type S: int
        :rtype: int
        """
        prefix={}
        prefix[0]=1
        n = len(A)
        count=0
        cur_sum=0
        for a in A:
            cur_sum+=a
            remain = cur_sum-S
            if remain in prefix:
                count += prefix[remain]
            prefix[cur_sum] = prefix.get(cur_sum, 0)+1
        return count