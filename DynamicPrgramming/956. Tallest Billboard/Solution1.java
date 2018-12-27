class Solution {
    public int tallestBillboard(int[] rods) {
        int n=rods.length;
        final int offset=5000;
        int[] dp=new int[offset+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        int cur=0, old;
        for (int rod:rods){
            old=cur;
            cur=1-cur;
            int[] prev=dp.clone();
            for (int diff=0; diff+rod<=offset; diff++){
                dp[diff+rod]=Math.max(dp[diff+rod], prev[diff]);
                int index=Math.abs(diff-rod);
                dp[index]=Math.max(dp[index], prev[diff]+Math.min(diff, rod));
            }
        }
        return dp[0];
    }
}