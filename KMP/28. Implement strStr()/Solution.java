class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        if (m==0){
            return 0;
        }
        int[] table=prefixTable(needle);//table shifted by 1
        int i=0, j=0;
        while (i<n&&j<m){
            if (haystack.charAt(i)==needle.charAt(j)){
                if (j==m-1)
                    return i-m+1;
                i++;
                j++;
            }else{
                j=table[j];
                if (j==-1){
                    i++;
                    j=0;//or j++
                }
            }
        }
        return (j==m)?(i-m+1):-1;
    }
    private int[] constructTable(String pattern){
        int m=pattern.length();
        int[] table=new int[m];//this is the table indicate how many prefix is matched
        for (int i=1, j=0; i<m; i++){
            while (j>0 && pattern.charAt(i)!=pattern.charAt(j)){
                j=table[j-1];
            }
            if (pattern.charAt(i)==pattern.charAt(j)){
                table[i]=j+1;
                j++;
            }else{
                table[i]=j;
            }
        }
        return table;
    }
    private int[] prefixTable(String pattern){
        int m=pattern.length();
        int i=1, j=0;
        int[] table=new int[m];
        while (i<m){
            if (pattern.charAt(i)==pattern.charAt(j)){
                j++;
                table[i++]=j;
            }else{
                if (j>0){
                    j=table[j-1];
                }else{
                    table[i++]=j; // that just mean table[i]=0
                }
            }
        }
        for (i=m-1; i>0; i--){
            table[i]=table[i-1];
        }
        table[0]=-1;
        return table;
    }
}