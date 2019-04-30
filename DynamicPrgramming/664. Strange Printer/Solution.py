class Solution:
    def strangePrinter(self, s: str) -> int:
        N=len(s)
        if N==0:
            return 0
        dp=[[1 if i==j else 0 for j in range(N)] for i in range(N)]
        
        for l in range(2, N+1):
            for i in range(0, N-l+1):
                j=i+l-1
                dp[i][j]=l
                for k in range(i, i+l-1):
                    cur=dp[i][k]+dp[k+1][j]
                    if s[k]==s[j]:
                        cur-=1
                    dp[i][j]=min(dp[i][j], cur)
        return dp[0][N-1]