class Solution {
    static final long MOD = (long)(1e9+7);
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        long[][] f = new long[n][n];
        for (int i=n-1; i>=0; i--){
            for (int j=i; j<n; j++){
                if (i==j){
                    f[i][j]=1;
                }else if (j-i==1){
                    f[i][j]=2;
                }else{
                    if (S.charAt(i)==S.charAt(j)){
                        int left=i+1;
                        int right=j-1;
                        while (left<=right && S.charAt(left)!=S.charAt(i)){
                            left++;
                        }
                        while (left<=right && S.charAt(right)!=S.charAt(i)){
                            right--;
                        }
                        if (left>right){
                            f[i][j]=2*f[i+1][j-1]+2;
                        }else if (left==right){
                            f[i][j]=2*f[i+1][j-1]+1;
                        }else{
                            f[i][j]=2*f[i+1][j-1]-f[left+1][right-1];
                        }
                    }else{
                        f[i][j]=f[i][j-1]+f[i+1][j]-f[i+1][j-1];
                    }
                }
                if (f[i][j]<0){
                    f[i][j]+=MOD;
                }
                f[i][j]%=MOD;
            }
        }
        return (int)f[0][n-1];
    }
}