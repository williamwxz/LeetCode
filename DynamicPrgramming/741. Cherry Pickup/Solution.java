class Solution {
    public int cherryPickup(int[][] grid) {
        int N=grid.length;
        int[][] dp=new int[N][N];
        dp[0][0]=grid[0][0];
        for (int n=1; n<2*N-1; n++){
            for (int i=0; i<N; i++){
                for (int p=0; p<N; p++){
                    int j=n-i, q=n-p;
                    if (j<0||j>=N||q<0||q>=N||grid[i][j]<0||grid[p][q]<0)
                        dp[i][p]=-1;
                    else{
                        if (i>0)
                            dp[i][p]=Math.max(dp[i][p], dp[i-1][p]);
                        if (p>0)
                            dp[i][p]=Math.max(dp[i][p], dp[i][p-1]);
                        if (i>0&&p>0)
                            dp[i][p]=Math.max(dp[i][p], dp[i-1][p-1]);
                        //if (i,j) has walked before, the cell should become 0
                        if (dp[i][p]>=0)
                            dp[i][p]+=grid[i][j]+((i!=p)?grid[p][q]:0);
                    }
                }
            }
        }
        return Math.max(dp[N-1][N-1], 0);
    }
}