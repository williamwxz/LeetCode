class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        def helper(s, l, r):
            n = len(s)
            while l>=0 and r<n and s[l]==s[r]:
                l-=1
                r+=1
            return s[l+1:r]
        n = len(s)
        result=""
        length=0

        for i in range(n):
            #odd length
            tmp = helper(s, i, i)
            if len(tmp)>length:
                result=tmp
                length = len(tmp)
            #even length
            if i<n-1:
                tmp = helper(s, i, i+1)
                if len(tmp)>length:
                    result=tmp
                    length=len(tmp)
        return result
