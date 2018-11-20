class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n==0){
            return 0;
        }
        int[] f = new int[n+1];
        f[0]=1;
        for (int i=1; i<=n; i++){
            if (s.charAt(i-1)>'0'){
                f[i] = f[i-1];
            }
            if (i>1){
                if (s.charAt(i-2)=='1' || s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'){
                    f[i]+=f[i-2];
                }
            }
        }
        return f[n];
    }
}