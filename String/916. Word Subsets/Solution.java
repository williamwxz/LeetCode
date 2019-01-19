class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result=new ArrayList<>();
        int[] restrict=new int[26];
        for (String b:B){
            int[] count=check(b);
            for (int i=0; i<26; i++){
                restrict[i]=Math.max(restrict[i], count[i]);
            }
        }
        for (String a:A){
            int[] count=check(a);
            int i=0;
            for (; i<26; i++){
                if (restrict[i]>0 && count[i]<restrict[i]){
                    break;
                }
            }
            if (i==26)
                result.add(a);
        }
        return result;
    }
    private int[] check(String s){
        int[] count=new int[26];
        for (int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        return count;
    }
}