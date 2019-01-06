class Solution {
    public boolean isRationalEqual(String S, String T) {
        return rationalize(S)==rationalize(T);
    }
    private double rationalize(String s){
        int n=s.length();
        int i=s.indexOf("(");
        if (i>1){
            String base=s.substring(0, i);
            String digits=s.substring(i+1, n-1);
            StringBuilder builder=new StringBuilder(base);
            for (int j=0; j<16; j++){
                builder.append(digits);
            }
            return Double.valueOf(builder.toString());
        }
        return Double.valueOf(s);
    }
}