class Solution {
    public String shortestSuperstring(String[] A) {
        int n=A.length;
        int[][] graph=new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                graph[i][j]=diff(A[i], A[j]);
                graph[j][i]=diff(A[j], A[i]);
            }
        }
        int[][] dp=new int[1<<n][n];
        int[][] path=new int[1<<n][n];
        for (int bit=0; bit<(1<<n); bit++){
            Arrays.fill(dp[bit], Integer.MAX_VALUE);
        }
        for (int i=0; i<n; i++)
            dp[1<<i][i]=A[i].length();
        int last=-1, min=Integer.MAX_VALUE;
        for (int bit=1; bit<(1<<n); bit++){
            for (int i=n-1; i>=0; i--){
                if ((bit&(1<<i))>0){
                    //the cur bit exist in the subset
                    int prev=bit-(1<<i);
                    for (int j=n-1; j>=0; j--){
                        if ((prev&(1<<j))>0&&dp[prev][j]!=Integer.MAX_VALUE&&dp[prev][j]+graph[j][i]<dp[bit][i]){
                            dp[bit][i]=dp[prev][j]+graph[j][i];
                            path[bit][i]=j;
                        }
                    }
                    if (bit==(1<<n)-1&&dp[bit][i]<min){
                        last=i;
                        min=dp[bit][i];
                    }
                }
            }
        }
        int curSet=(1<<n)-1, prev=-1;
        StringBuilder builder=new StringBuilder();
        while (curSet>0){
            if (curSet==(1<<n)-1){
                builder.append(A[last]);
            }else{
                int curlen=A[last].length(), prevlen=A[prev].length();
                builder.insert(0, A[last].substring(0, curlen+graph[last][prev]-prevlen));
            }
            prev=last;
            last=path[curSet][last];
            curSet-=(1<<prev);
        }
        return builder.toString();
    }
    private int diff(String a, String b){
        if (a.equals(b))
            return 0;
        int n=a.length(), m=b.length();
        for (int i=1; i<n; i++){
            if (b.startsWith(a.substring(i))){
                return m-n+i; //n+m-(n-i)-n
            }
        }
        return m;
    }
}