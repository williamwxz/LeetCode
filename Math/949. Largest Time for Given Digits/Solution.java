class Solution {
    public String largestTimeFromDigits(int[] A) {
        int n = A.length;
        String result = "";
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    if (i==j || j==k || k==i)
                        continue;
                    int z = 6-i-j-k;
                    String hour = ""+A[i]+A[j];
                    String mins = ""+A[k]+A[z];
                    String time = hour+":"+mins;
                    if (hour.compareTo("24")<0 && mins.compareTo("60")<0 &&result.compareTo(time)<0){
                        result = time;
                    }
                }
            }
        }
        return result;
    }
}