class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int n=stamp.length();
        int m=target.length();
        List<Integer> result=new ArrayList<>();
        boolean[] visited=new boolean[m];
        int count=0;
        char[] S=stamp.toCharArray(), T=target.toCharArray();
        while (count<m){
            int i=0;
            for (;i<m-n+1;i++){
                if (!visited[i]&&match(S, T, i)){
                    visited[i]=true;
                    result.add(i);
                    for (int j=i; j<i+n;j++){
                        if (T[j]!='#')
                            count++;
                        T[j]='#';
                    }
                    break;
                }
            }
            if (i==m-n+1)
                return new int[0];
        }
        Collections.reverse(result);
        int[] res=new int[result.size()];
        for (int i=0; i<res.length; i++)
            res[i]=result.get(i);
        return res;
    }
    private boolean match(char[] s, char[] t, int start){
        for (int i=0; i<s.length; i++){
            if (start+i>=t.length)
                return false;
            if (s[i]!=t[start+i]&&t[start+i]!='#')
                return false;
        }
        return true;
    }
}