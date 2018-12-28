class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int m=stones[0].length;
        int[] parent=new int[n];
        for (int i=0; i<n; i++)
            parent[i]=i;
        int count=n;
        for (int i=0; i<n; i++){
            int[] s1=stones[i];
            for (int j=i+1; j<n; j++){
                int[] s2=stones[j];
                //check if connected
                if (s1[0]==s2[0]||s1[1]==s2[1]){
                    if (union(i, j, parent)){
                        count--;
                    }
                }
            }
        }
        return n-count;
    }
    private int find(int node, int[] parent){
        while (node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
    private boolean union(int node1, int node2, int[] parent){
        int p1=find(node1, parent);
        int p2=find(node2, parent);
        if(p1==p2)
            return false;
        parent[p2]=p1;
        return true;
    }
}