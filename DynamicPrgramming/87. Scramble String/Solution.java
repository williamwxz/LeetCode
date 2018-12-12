class Solution {
    //similiar to check if tree is swapped
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        String key=s1+s2;
        if (map.containsKey(key)){
            return map.get(key);
        }
        if (s1.equals(s2)){
            return true;
        }
        boolean result=false;
        for (int i=1; i<n; i++){
            if (isScramble(s1.substring(0,i), s2.substring(0, i))&&isScramble(s1.substring(i),s2.substring(i))
               || isScramble(s1.substring(0,i), s2.substring(n-i))&&isScramble(s1.substring(i),s2.substring(0,n-i))){
                result=true;
                break;
            }
        }
        map.put(key, result);
        return result;
    }
}