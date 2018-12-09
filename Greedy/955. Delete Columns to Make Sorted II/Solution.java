class Solution {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        int m = A[0].length();
        int result=0;
        for (int i=0; i<m; i++){
            boolean sorted=true;
            int j=0;
            for (; j<n-1; j++){
                if (A[j].substring(0,i+1).compareTo(A[j+1].substring(0,i+1))>0){
                    result++;
                    sorted=false;
                    break;
                }
            }
            if (!sorted){
                for (int k=0; k<n; k++){
                    A[k]=A[k].substring(0,i)+A[k].substring(i+1);
                }
                i--;
                m--;
            }
        }
        return result;
    }
}