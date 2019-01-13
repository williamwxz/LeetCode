class Solution {
    public int largestPerimeter(int[] A) {
        int n=A.length;
        Arrays.sort(A);
        for (int i=n-3; i>=0; i--){
            if (A[i]+A[i+1]>A[i+2]){
                return A[i]+A[i+1]+A[i+2];
            }
        }
        return 0;
    }
}