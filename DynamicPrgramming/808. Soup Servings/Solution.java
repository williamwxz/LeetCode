class Solution {
    public double soupServings(int N) {
        if (N>4800)
            return 1.0;
        N=(N+24)/25;
        double[][] map=new double[N+1][N+1];
        return helper(N, N, map);
    }
    private double helper(int A, int B, double[][] map){
        if (A<=0 && B<=0){
            return 0.5;
        }else if (A<=0){
            return 1.0;
        }else if (B<=0){
            return 0.0;
        }
        if (map[A][B]>0.0)
            return map[A][B];
        map[A][B]=0.25*(helper(A-4, B, map)+helper(A-3, B-1, map)+helper(A-2, B-2, map)+helper(A-1, B-3, map));
        return map[A][B];
    }
}