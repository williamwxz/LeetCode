class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int prefix=0, res=0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        for (int a:A){
            prefix=(prefix+a)%K;
            prefix+=(prefix>=0)?0:K;
            int tmp=map.getOrDefault(prefix, 0);
            res+=tmp;
            map.put(prefix, tmp+1);
        }
        return res;
    }
}