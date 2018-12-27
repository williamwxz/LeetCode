class Solution {
    public int tallestBillboard(int[] rods) {
        int n=rods.length;
        final int offset=5000;
        Map<Integer, Integer> dp=new HashMap<>();
        dp.put(0,0);
        for (int rod:rods){
            Map<Integer, Integer> cur=new HashMap<>(dp);
            for (int d:cur.keySet()){
                dp.put(d+rod, Math.max(dp.getOrDefault(d+rod, 0), cur.get(d)));
                int index=Math.abs(d-rod);
                dp.put(index, Math.max(dp.getOrDefault(index, 0), cur.get(d)+Math.min(d, rod)));
            }
        }
        return dp.get(0);
    }
}