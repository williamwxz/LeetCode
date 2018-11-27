class Solution {
    //only pick the max one
    public int jump(int[] nums) {
        int n = nums.length;
        int nextJump=0, curJump=0, totalJump=0;
        for (int i=0; i<n-1; i++){
            nextJump = Math.max(nextJump, i+nums[i]);
            if (i==curJump){
                totalJump++;
                curJump = nextJump;
            }
        }
        return totalJump;
    }
}