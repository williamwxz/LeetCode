public class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        char[] input=s.toCharArray();
        int n=input.length;
        reverse(input, 0, n-1);
        int start=0;
        for (int i=0; i<n; i++){
            if (input[i]==' '||i==n-1){
                i=(i==n-1)?i+1:i;
                reverse(input, start, i-1);
                start=i+1;
            }
        }
        return removeSpaces(input);
    }
    private void reverse(char[] s, int start, int end){
        while (start<end){
            swap(s, start++, end--);
        }
    }
    private String removeSpaces(char[] s){
        int i=0, j=0;
        int n=s.length;
        while (j<n){
            if (s[j]!=' '||(i>0&&s[i-1]!=' ')){
                swap(s, i++, j);
            }
            j++;
        }
        return (new String(s)).substring(0, i);
    }
    private void swap(char[] s, int p, int t){
        char tmp=s[p];
        s[p]=s[t];
        s[t]=tmp;
    }
}