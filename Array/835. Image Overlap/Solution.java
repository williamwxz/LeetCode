class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int max=0;
        for (int i=-n+1; i<n; i++){
            for (int j=-m+1; j<m; j++){
                int sum=0;
                for (int row=0; row<n; row++){
                    int indexR = i+row;
                    for (int col=0; col<m; col++){
                        int indexC = j+col;
                        int cell = 0;
                        if (indexR<0 || indexR>=n || indexC<0 || indexC>=m){
                            cell=0;
                        }else{
                            cell = (A[indexR][indexC]&B[row][col]);
                        }
                        sum += cell;
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}