class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void subsetsWithDup(int[] nums, int index, List<Integer> track, List<List<Integer>> result){
        int n = nums.length;
        if (index>=n){
            result.add(new ArrayList<>(track));
            return;
        }
        //add or not add
        track.add(nums[index]);
        subsetsWithDup(nums, index+1, track, result);
        track.remove(track.size()-1);
        while (index<n-1 && nums[index]==nums[index+1]){
            index++;
        }
        subsetsWithDup(nums, index+1, track, result);
    }
}