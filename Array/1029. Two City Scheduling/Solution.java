class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N=costs.length;
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return (a[0]-a[1])<(b[0]-b[1])?-1:1;
            }
        });
        int res=0;
        for (int i=0; i<N/2; i++){
            res+=costs[i][0];
        }
        for (int i=N/2; i<N; i++){
            res+=costs[i][1];
        }
        return res;
    }
}