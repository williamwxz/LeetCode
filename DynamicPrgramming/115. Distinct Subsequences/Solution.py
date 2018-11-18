class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        n = len(s)
        m = len(t)
        f = [[0 for j in range(m+1)] for i in range(2)]
        cur=0
        old=-1
        for i in range(2):
            f[i][0]=1
        for i in range(1, n+1):
            old = cur
            cur = 1-cur
            for j in range(1, m+1):
                f[cur][j]=f[old][j]
                if s[i-1]==t[j-1]:
                    f[cur][j]+=f[old][j-1]
        return f[cur][m]
        