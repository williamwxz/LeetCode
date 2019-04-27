class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for (int j=1; j<=n; j++){
            // decrement because cost=x+max(cost[i:x-1], cost[x+1:j])
            // we will need to know cost[x+1:j]
            for (int i=j-1; i>0; i--){
                if (i+1==j){
                    //when only two numbers
                    dp[i][j]=i;
                }else{
                    //at least 3 numbers
                    int cost=Integer.MAX_VALUE;
                    for (int x=i+1; x<j; x++){
                        int cur=x + Math.max(dp[i][x-1], dp[x+1][j]);
                        cost=Math.min(cost, cur);
                    }
                    dp[i][j]=cost;
                }
            }
        }
        return dp[1][n];
    }
}