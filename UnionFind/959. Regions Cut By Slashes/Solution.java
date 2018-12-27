class Solution {
    int count=0;
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int[] parent=new int[n*n*4];
        count=n*n*4;
        for (int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i>0){
                    union(c(i, j, 0, n), c(i-1, j, 2,n), parent);
                }
                if (j>0){
                    union(c(i, j, 3, n), c(i, j-1, 1, n), parent);
                }
                if (grid[i].charAt(j)=='/'){
                    union(c(i, j, 1, n),c(i, j, 2, n), parent);
                    union(c(i, j, 0, n),c(i, j, 3, n), parent);
                }else if (grid[i].charAt(j)=='\\'){
                    union(c(i, j, 0, n),c(i, j, 1, n), parent);
                    union(c(i, j, 2, n),c(i, j, 3, n), parent);
                }else{
                    union(c(i, j, 0, n),c(i, j, 1, n), parent);
                    union(c(i, j, 2, n),c(i, j, 3, n), parent);
                    union(c(i, j, 1, n),c(i, j, 2, n), parent);
                    union(c(i, j, 0, n),c(i, j, 3, n), parent);
                }
            }
        }
        return count;
    }
    private int find(int node, int[] parent){
        while(node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
    private boolean union(int node1, int node2, int[] parent){
        int p1=find(node1, parent);
        int p2=find(node2, parent);
        if (p1==p2){
            return false;
        }
        parent[p2]=p1;
        count--;
        return true;
    }
    private int c(int i, int j, int k, int n){
        return (i*n+j)*4+k;
    }
}