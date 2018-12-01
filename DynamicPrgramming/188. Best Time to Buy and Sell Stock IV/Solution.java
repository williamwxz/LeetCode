class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        if (k>n){
            return maxProfit(prices);
        }
        int[][] f = new int[2][2*k+1];
        int cur=0, old;
        for (int j=1; j<2*k+1; j++){
            f[cur][j] = Integer.MIN_VALUE;
        }
        f[cur][0] = 0; //start from 0
        for (int i=1; i<=n; i++){
            old = cur;
            cur = 1-cur;
            for (int j=0; j<2*k+1; j++){
                if ((j%2)==1){
                    //hold
                    f[cur][j] = f[old][j];
                    if (f[old][j-1]!=Integer.MIN_VALUE){
                        f[cur][j] = Math.max(f[cur][j], f[old][j-1]-prices[i-1]);
                    }
                }else{
                    //not hold
                    f[cur][j] = f[old][j];
                    if (j>1 && f[old][j-1]!=Integer.MIN_VALUE){
                        f[cur][j] = Math.max(f[cur][j], f[old][j-1]+prices[i-1]);
                    }
                }
            }
        }
        int globalMax = 0;
        for (int j=0; j<2*k+1; j+=2){
            globalMax = Math.max(globalMax, f[cur][j]);
        }
        return globalMax;
    }
    private int maxProfit(int[] prices){
        int profit=0;
        int n = prices.length;
        for (int i=1; i<n; i++){
            profit += Math.max(0, prices[i]-prices[i-1]);
        }
        return profit;
    }
}