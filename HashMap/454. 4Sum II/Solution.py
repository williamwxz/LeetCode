class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        prefix = dict()
        for a in A:
            for b in B:
                res = a+b
                prefix[res] = prefix.get(res,0)+1
        count=0
        for c in C:
            for d in D:
                res=c+d
                count += prefix.get(-res,0)
        return count
        