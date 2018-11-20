class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s);
        if n==0:
            return 0
        f=[0 for i in range(n+1)]
        f[0]=1
        for i in range(1,n+1):
            if ord(s[i-1])>ord('0'):
                f[i]=f[i-1]
            if i>1 and (ord(s[i-2])==ord('1') or (ord(s[i-2])==ord('2') and ord(s[i-1])<=ord('6'))):
                f[i]+=f[i-2]
        return f[n]
        
