class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n=positions.length;
        List<Integer> res=new ArrayList<>();
        int[] points=new int[2*n];
        for (int i=0; i<n; i++){
            points[2*i]=positions[i][0];
            points[2*i+1]=positions[i][0]+positions[i][1]-1;
        }
        //get the points in line
        Arrays.sort(points);
        int max=0;
        int[] ceiling=new int[2*n];
        for (int[] pos:positions){
            int start=Arrays.binarySearch(points, pos[0]);
            int end=points[start]+pos[1]-1;
            int height=0;
            for (int i=start; i<2*n&&points[i]<=end; i++){
                height=Math.max(height, ceiling[i]);
            }
            height+=pos[1];
            for (int i=start;i<2*n&&points[i]<=end; i++){
                ceiling[i]=height;
            }
            max=Math.max(max, height);
            res.add(max);
        }
        return res;
    }
}