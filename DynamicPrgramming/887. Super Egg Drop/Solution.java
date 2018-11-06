class Solution1 {
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

class Solution2 {
    public int superEggDrop(int K, int N) {
        int[][] f = new int[2][K+1];
        int min=0; //maximum moves for dropping eggs
        int cur=0, old;
        while (f[cur][K]<N){
            min++;
            old = cur;
            cur = 1-cur;
            for (int k=1; k<=K; k++){
                f[cur][k] = f[old][k-1]+f[old][k]+1;
            }
        }
        return min;
    }
}