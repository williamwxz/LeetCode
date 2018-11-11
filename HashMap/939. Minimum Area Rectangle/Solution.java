class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>(); //x: set(y)
        int n = points.length;
        if (n<4){
            return 0;
        }
        for (int[] point: points){
            Set<Integer> y = map.getOrDefault(point[0], new HashSet<>());
            y.add(point[1]);
            map.put(point[0], y);
        }
        int min = Integer.MAX_VALUE;
        for (int[] p1:points){
            for (int[] p2:points){
                if (p1[0]==p2[0] || p1[1]==p2[1]){
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])){
                    int area = Math.abs(p1[0]-p2[0])*Math.abs(p1[1]-p2[1]);
                    min = Math.min(min, area);
                }
            }
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}