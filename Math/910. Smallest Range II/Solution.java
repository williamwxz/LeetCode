class Solution {
    //sort A
    //Case 1: left of e1, left of e2, result=A[n-1]-A[0]
    //Case 2: right of e1, right of e2, result=A[n-1]-A[0]
    //Case 3: right of e1, left of e2, this is the case we care
    //Case 4: left of e1, right of e2, don't consider this case
    public int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int result=A[n-1]-A[0];
        int left=A[0]+K, right=A[n-1]-K;
        for (int i=0; i<n-1; i++){
            int max=Math.max(right, A[i]+K);
            int min=Math.min(left, A[i+1]-K);
            result=Math.min(result, max-min);
        }
        return result;
    }
}