class Solution {
    //union find
    //most difficult part is: not union other node, but union their factors
    public int largestComponentSize(int[] A) {
        int n = A.length;
        int max = 1;
        for (int a:A){
            max = Math.max(max, a);
        }
        int[] parents = new int[max+1];
        for (int i=0; i<parents.length; i++){
            parents[i]=i;
        }
        for (int a:A){
            for (int k=2; k<=Math.sqrt(a); k++){
                if (a%k==0){
                    union(parents, a, k);
                    union(parents, a, a/k);
                }
            }
        }
        Map<Integer, Integer> counts=new HashMap<>();
        int result=0;
        for (int a:A){
            int p = find(parents, a);
            int count=counts.getOrDefault(p, 0)+1;
            result=Math.max(result, count);
            counts.put(p, count);
        }
        return result;
    }
    private int find(int[] parents, int node){
        while (node!=parents[node]){
            parents[node]=parents[parents[node]];
            node = parents[node];
        }
        return node;
    }
    private boolean union(int[] parents, int node1, int node2){
        int p1 = find(parents, node1);
        int p2 = find(parents, node2);
        if (p1==p2){
            return false;
        }
        parents[p2]=p1;
        return true;
    }
}