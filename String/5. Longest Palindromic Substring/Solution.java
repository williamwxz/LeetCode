class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n==0){
            return s;
        }
        int left=0, right=0;
        int max=0;
        for (int i=0; i<n; i++){
            if (isPali(s, i-max-1, i)){
                left=i-max-1;
                right=i;
                max += 2;
            }else if (isPali(s, i-max, i)){
                left=i-max;
                right=i;
                max+=1;
            }
        }
        return s.substring(left, right+1);
    }
    private boolean isPali(String s, int left, int right){
        if (left<0){
            return false;
        }
        int n = s.length();
        while (left<right){
            if (s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}