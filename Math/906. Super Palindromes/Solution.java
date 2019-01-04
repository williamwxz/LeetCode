class Solution {
    public int superpalindromesInRange(String L, String R) {
        int[] result=new int[1];
        long l=Long.parseLong(L);
        long r=Long.parseLong(R);
        //even
        dfs("", l, r, result);
        for (int i=0; i<10; i++){
            dfs(Integer.toString(i), l, r, result);
        }
        return result[0];
    }
    private void dfs(String mid, long l, long r, int[] result){
        if (mid.length()>9)
            return;
        if (mid.length()>0&&mid.charAt(0)!='0'){
            long num=Long.parseLong(mid);
            num *=num;
            if (num>r)
                return;
            if (num>=l&&isPali(Long.toString(num)))
                result[0]++;
        }
        for (int i=0; i<10; i++){
            String next=i+mid+i;
            dfs(next, l, r, result);
        }
    }
    private boolean isPali(String s){
        int l=0, r=s.length()-1;
        while (l<r){
            if (s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
}