class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void subsetsWithDup(int[] nums, int index, List<Integer> track, List<List<Integer>> result){
        int n = nums.length;
        result.add(new ArrayList<>(track));
        if (index>=n){
            return;
        }
        for (int i=index; i<n; i++){
            if (i>index && nums[i-1]==nums[i]){
                continue;
            }
            track.add(nums[i]);
            subsetsWithDup(nums, i+1, track, result);
            track.remove(track.size()-1);
        }
    }
}