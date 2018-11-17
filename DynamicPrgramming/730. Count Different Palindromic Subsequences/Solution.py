class Solution(object):
    def countPalindromicSubsequences(self, S):
        """
        :type S: str
        :rtype: int
        """
        n = len(S)
        f = [[0 for j in range(n)] for i in range(n)]
        MOD = 1e9+7
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if i==j:
                    f[i][j]=1
                elif j-i==1:
                    f[i][j]=2
                else:
                    if S[i]==S[j]:
                        left, right=i+1, j-1
                        while left<=right and S[left]!=S[i]:
                            left+=1
                        while left<=right and S[right]!=S[i]:
                            right-=1
                        if left>right:
                            #no same char found
                            f[i][j] = 2*f[i+1][j-1]+2
                        elif left==right:
                            #one same char found
                            f[i][j] = 2*f[i+1][j-1]+1
                        else:
                            #at least two char found
                            f[i][j] = 2*f[i+1][j-1]-f[left+1][right-1]
                    else:
                        f[i][j]=f[i][j-1]+f[i+1][j]-f[i+1][j-1]
                if f[i][j]<0:
                    f[i][j]+=MOD
                f[i][j]%=MOD
        return int(f[0][n-1])
        