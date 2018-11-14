class Solution {
    //use min/max value to construct array for BIT
    //need min value to construct array, in case there are negative value
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (n==0){
            return result;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num:nums){
            min = Math.min(num, min);
        }
        for (int num:nums){
            int cur = num-min+1;
            max = Math.max(max, cur);
        }
        int[] array = new int[max+1];
        for (int i=n-1; i>=0; i--){
            int num = nums[i]-min+1;
            //num-1 to find the smaller number
            result.add(query(array, num-1));
            update(array, num, 1);
        }
        Collections.reverse(result);
        return result;
    }
    
    private void update(int[] array, int i, int delta){
        int n = array.length;
        while (i<n){
            array[i] += delta;
            i += lowbit(i);
        }
    }
    
    private int query(int[] array, int i){
        int sum=0;
        while (i>0){
            sum += array[i];
            i -= lowbit(i);
        }
        return sum;
    }
    
    private int lowbit(int num){
        return num&(-num);
    }
}