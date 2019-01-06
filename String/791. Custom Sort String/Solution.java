class Solution {
    public String customSortString(String S, String T) {
        int n=S.length();
        int m=T.length();
        int[] exist=new int[26];
        for (int i=0; i<m; i++)
            exist[T.charAt(i)-'a']++;
        StringBuilder builder=new StringBuilder();
        for (int i=0; i<n; i++){
            char c=S.charAt(i);
            while(exist[c-'a']>0){
                builder.append(c);
                exist[c-'a']--;
            }
        }
        for (char c='a'; c<='z'; c++){
            while (exist[c-'a']>0){
                builder.append(c);
                exist[c-'a']--;
            }
        }
        return builder.toString();
    }
}