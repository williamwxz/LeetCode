class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        //key: prefix sum
        //value: count
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count=0;
        int sum=0;
        for (int a:A){
            sum += a;
            if (map.containsKey(sum-S)){
                count+=map.get(sum-S);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}