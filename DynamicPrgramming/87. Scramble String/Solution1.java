class Solution {
    //similiar to check if tree is swapped
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s1.equals(s2)){
            return true;
        }
        int[] count=new int[26];
        for (int i=0; i<n; i++){
            count[(s1.charAt(i)-'a')]++;
            count[(s2.charAt(i)-'a')]--;
        }
        for (int i=0; i<26; i++){
            if (count[i]!=0){
                return false;
            }
        }
        boolean result=false;
        for (int i=1; i<n; i++){
            if (isScramble(s1.substring(0,i), s2.substring(0, i))&&isScramble(s1.substring(i),s2.substring(i))
               || isScramble(s1.substring(0,i), s2.substring(n-i))&&isScramble(s1.substring(i),s2.substring(0,n-i))){
                result=true;
                break;
            }
        }
        return result;
    }
}