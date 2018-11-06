class Solution {
    public int superEggDrop(int K, int N) {
        int[][] f = new int[N+1][K+1];
        int min=0; //maximum moves for dropping eggs
        while (f[min][K]<N){
            min++;
            for (int k=1; k<=K; k++){
                f[min][k] = f[min-1][k-1]+f[min-1][k]+1;
            }
        }
        return min;
    }
}