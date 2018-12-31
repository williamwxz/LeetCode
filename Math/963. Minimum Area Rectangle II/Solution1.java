class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n=points.length;
        Map<String, List<int[]>> map=new HashMap<>(); //"c_x, c_y,dist": list of points
        for (int i=0; i<n; i++){
            int[] p1=points[i];
            for (int j=i+1; j<n; j++){
                int[] p2=points[j];
                double cx=(double)((p1[0]+p2[0]))/2;
                double cy=(double)((p1[1]+p2[1]))/2;
                double dist=(double)(Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1], 2));
                String key=cx+","+cy+","+dist;
                List<int[]> list=map.computeIfAbsent(key, k->new ArrayList<>());
                list.add(new int[]{i, j});
            }
        }
        double result=Double.MAX_VALUE;
        for (Map.Entry<String, List<int[]>> entry:map.entrySet()){
            List<int[]> list=entry.getValue();
            int size=list.size();
            if (size>1){
                for (int i=0; i<size; i++){
                    for (int j=i+1; j<size; j++){
                        int[] p1=points[list.get(i)[0]];
                        int[] p2=points[list.get(i)[1]];
                        int[] p3=points[list.get(j)[0]];
                        double c1=(double)(Math.pow(p1[0]-p3[0], 2)+Math.pow(p1[1]-p3[1], 2));
                        double c2=(double)(Math.pow(p2[0]-p3[0], 2)+Math.pow(p2[1]-p3[1], 2));
                        double area=c1*c2;
                        result=Math.min(result, area);
                    }
                }
            }
        }
        return (result==Double.MAX_VALUE)?0.0:Math.sqrt(result);
    }
}