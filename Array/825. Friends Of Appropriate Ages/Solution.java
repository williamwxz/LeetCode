class Solution {
    public int numFriendRequests(int[] ages) {
        int n=121;
        int[] numInAge = new int[n]; 
        int[] sum = new int[n];
        for(int i : ages) 
            numInAge[i]++;
        for(int i = 1; i<n; ++i) 
            sum[i] = numInAge[i] + sum[i - 1];
        int result = 0;
        for(int i = 15; i<n; ++i) {
            if(numInAge[i]>0){
                int count=sum[i]-sum[i/2+7];
                result+=count*numInAge[i]-numInAge[i];
            }
        }
        return result;
    }
}