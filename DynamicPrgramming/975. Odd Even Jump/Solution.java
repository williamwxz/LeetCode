class Solution {
    public int oddEvenJumps(int[] A) {
        int n=A.length;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        boolean[] high=new boolean[n], low=new boolean[n];
        int res=0;
        high[n-1]=true;
        low[n-1]=true;
        for (int i=n-1; i>=0; i--){
            Integer larger=map.ceilingKey(A[i]);
            if (larger!=null)
                high[i]=low[map.get(larger)];
            Integer smaller=map.floorKey(A[i]);
            if (smaller!=null)
                low[i]=high[map.get(smaller)];
            System.out.println(high[i]);
            System.out.println(low[i]);
            System.out.println();
            if (high[i])
                res++;
            map.put(A[i], i);
        }
        return res;
    }
}