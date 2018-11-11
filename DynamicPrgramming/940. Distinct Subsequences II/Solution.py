class Solution(object):
    def distinctSubseqII(self, S):
        """
        :type S: str
        :rtype: int
        """
        endWith = [0 for i in range(26)]
        n = len(S)
        mod = 10**9+7
        for i in S:
            endWith[ord(i)-ord('a')] = sum(endWith)+1
        return sum(endWith)%mod