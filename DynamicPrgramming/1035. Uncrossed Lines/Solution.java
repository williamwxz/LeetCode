class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int N=A.length;
        int M=B.length;
        int[][] dp=new int[N+1][M+1];
        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                if (A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }
}