class Solution {
    public int integerBreak(int n) {
        int[] f = new int[n+1];
        f[0]=Integer.MIN_VALUE; //impossible
        f[1]=1;
        for (int i=2; i<=n; i++){
            f[i]=(i==n)?1:i;
            for (int j=1; j<=i/2; j++){
                f[i]=Math.max(f[i], f[j]*f[i-j]);
            }
        }
        return f[n];
    }
}