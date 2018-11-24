class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        int diff = 0;
        for (int num:nums){
            diff ^= num;
        }
        //get either 1 bit for dividing numbers into two groups
        diff = lowestOneBit(diff);
        for (int num:nums){
            if ((num&diff)==0){
                result[0]^=num;
            }else{
                result[1]^=num;
            }
        }
        return result;
    }
    private int lowestOneBit(int bit){
        return bit&-bit;
    }
}