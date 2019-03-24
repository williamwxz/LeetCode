class Solution {
    public int expressiveWords(String S, String[] words) {
        int res=0;
        for (String word:words){
            res+=check(S,word)?1:0;
        }
        return res;
    }
    private boolean check(String s, String w){
        int N=s.length(), M=w.length();
        int i=0, j=0;
        while(j<M){
            if (i<N&&s.charAt(i)==w.charAt(j)){
                i++;
                j++;
            }else if (i>0&&i<N-1&&s.charAt(i-1)==s.charAt(i)&&s.charAt(i)==s.charAt(i+1)){
                i++;
            }else if (i>1&&i<N&&s.charAt(i-2)==s.charAt(i-1)&&s.charAt(i-1)==s.charAt(i)){
                i++;
            }else{
                return false;
            }
        }
        while (i<N){
            if (i>0&&i<N-1&&s.charAt(i-1)==s.charAt(i)&&s.charAt(i)==s.charAt(i+1)){
                i++;
            }else if (i>1&&i<N&&s.charAt(i-2)==s.charAt(i-1)&&s.charAt(i-1)==s.charAt(i)){
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
}