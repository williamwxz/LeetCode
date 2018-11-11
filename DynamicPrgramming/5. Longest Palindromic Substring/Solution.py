class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        f[i][j] = f[i+1][j-1]+2 if s[i]==s[j]
                = 0 if s[i]!=s[j]
        """
        n = len(s)
        f = [[0 for j in range(n)] for i in range(n)]
        length=0
        left=0
        right=0
        for i in range(n-1,-1,-1):
            for j in range(i,n):
                if i==j:
                    f[i][j]=1
                elif j-1==i:
                    if s[i]==s[j]:
                        f[i][j]=2
                else:
                    if s[i]==s[j] and f[i+1][j-1]>0:
                        f[i][j] = f[i+1][j-1]+2
                if f[i][j]>length:
                    left=i
                    right=j
                    length = f[i][j]
        return s[left:right+1]

