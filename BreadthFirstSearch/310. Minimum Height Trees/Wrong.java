class Solution {
    //no duplicate edges, undirected
    //node 0 to n-1, list of edges
    //solution 1: using bfs
    //      1. construct graph
    //      2. bfs return height, 
    //result: TLE
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge:edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        int min=n;
        for (int i=0; i<n; i++){
            int height = getHeight(i, graph);
            if (height<=min){
                if (height<min){
                    result = new ArrayList<>();
                }
                result.add(i);
                min = height;
            }
        }
        return result;
    }
    
    private int getHeight(int root, Map<Integer, List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        Set<Integer> visited = new HashSet<>();
        visited.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                int cur = queue.poll();
                List<Integer> neighbors = graph.get(cur);
                if (neighbors!=null){
                    for (int nei:neighbors){
                        if (visited.add(nei)){
                            queue.offer(nei);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
    
}