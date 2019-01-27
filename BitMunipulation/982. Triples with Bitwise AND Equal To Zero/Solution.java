class Solution {
    public int countTriplets(int[] A) {
        int n=A.length;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int tmp=A[i]&A[j];
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
            }
        }
        int res=0;
        for (int k=0; k<n; k++){
            for (int key:map.keySet()){
                if ((key&A[k])==0){
                    res+=map.get(key);
                }
            }
        }
        return res;
    }
}