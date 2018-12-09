class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n+1][m+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=m; j++){
                if (i==0){
                    f[i][j]=j;
                }else if (j==0){
                    f[i][j]=i;
                }else{
                    if (word1.charAt(i-1)==word2.charAt(j-1)){
                        f[i][j]=f[i-1][j-1];
                    }else{
                        f[i][j]=Math.min(f[i-1][j-1], Math.min(f[i][j-1], f[i-1][j]))+1;
                    }
                }
            }
        }
        return f[n][m];
    }
}