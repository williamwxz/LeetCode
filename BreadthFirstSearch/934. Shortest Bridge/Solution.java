class Solution1 {
    //1. union find, the get their cluster
    //2. bfs from each cell "1", to other cluster, remember bfs on the cell which is 0
    public int shortestBridge(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] parents = new int[n*m];
        final int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        for (int i=0; i<parents.length; i++){
            parents[i] = i;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (A[i][j]!=1){
                    continue;
                }
                for (int[] dir:directions){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if (x>=0&&x<n&&y>=0&&y<m&&A[x][y]==1){
                        union(parents, i*m+j, x*m+y);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (A[i][j]!=1){
                    continue;
                }
                int root = find(parents, i*m+j);
                int step = bfs(A, parents, i, j, root);
                min = Math.min(min, step);
            }
        }
        return min;
    }
    private int find(int[] parents, int node){
        while (node!=parents[node]){
            parents[node] = parents[parents[node]];
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
    private int bfs(int[][] A, int[] parents, int x, int y, int root){
        int n = A.length;
        int m = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        int step=0;
        boolean[][] visited = new boolean[n][m];
        final int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int[] cur = queue.poll();
                for (int[] dir:directions){
                    int nextX = cur[0]+dir[0];
                    int nextY = cur[1]+dir[1];
                    if (nextX>=0&&nextX<n&&nextY>=0&&nextY<m&&!visited[nextX][nextY]){
                        visited[nextX][nextY]=true;
                        if (A[nextX][nextY]==1){
                            //check if diff cluster
                            int nei = find(parents, nextX*m+nextY);
                            if (nei!=root){
                                return step;
                            }
                        }else{
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            step++;
        }
        return Integer.MAX_VALUE;
    }
}