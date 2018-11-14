class Solution {
    //left[] - first index of subarray with size k, max sum
    //right[] - first index of subarray with size k, max sum
    //we will also need prefix-sum
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0]=nums[0];
        for (int i=1; i<n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        int[] left = new int[n];
        int leftMax = prefix[k-1];
        for (int i=1; i<=n-k; i++){
            int cur = prefix[i+k-1]-prefix[i-1];
            if (cur>leftMax){
                left[i] = i;
                leftMax = cur;
            }else{
                left[i] = left[i-1];
            }
        }
        int[] right = new int[n];
        right[n-k] = n-k;
        int rightMax = prefix[n-1]-prefix[n-k-1];
        for (int i=n-k-1; i>=0;i--){
            int cur = prefix[i+k-1]-((i>0)?prefix[i-1]:0);
            if (cur>rightMax){
                right[i]=i;
                rightMax=cur;
            }else{
                right[i] = right[i+1];
            }
        }
        int[] result = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i=k; i<=n-2*k; i++){
            int l = left[i-k], r=right[i+k];
            leftMax = prefix[l+k-1]-((l>0)?prefix[l-1]:0);
            rightMax = prefix[r+k-1]-((r>0)?prefix[r-1]:0);
            int cur = leftMax+rightMax+prefix[i+k-1]-prefix[i-1];
            if (cur>max){
                result[0] = l;
                result[1] = i;
                result[2] = r;
                max = cur;
            }
        }
        return result;
    }
}