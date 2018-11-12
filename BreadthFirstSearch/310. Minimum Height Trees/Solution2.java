class Solution {
    /*reverse BFS, start from the leaf, more like topological sort
    Very import note: refer to readme.md
    */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n==1){
            result.add(0);
            return result;
        }
        //construct graph
        Set<Integer>[] graph = new HashSet[n];
        for (int i=0; i<n; i++){
            graph[i] = new HashSet<>();
        }
        int[] indegrees = new int[n];
        for (int[] edge:edges){
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (indegrees[i]==1){
                leaves.offer(i);
            }
        }
        while (n>2){
            int size = leaves.size();
            n -= size;
            for (int i=0; i<size; i++){
                int cur = leaves.poll();
                indegrees[cur]--;
                for (int p:graph[cur]){
                    if (indegrees[p]==0){
                        continue;
                    }
                    indegrees[p]--;
                    if (indegrees[p]==1){
                        leaves.offer(p);
                    }
                }
            }
        }
        while (!leaves.isEmpty()){
            result.add(leaves.poll());
        }
        return result;
    }
}