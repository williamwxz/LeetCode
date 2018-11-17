class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        f = [0 for i in range(n+1)]
        f[1]=1
        for i in range(2, n+1):
            if i<n:
                f[i]=i
            for j in range(1, i/2+1):
                f[i]=max(f[i], f[j]*f[i-j])
        return f[n]