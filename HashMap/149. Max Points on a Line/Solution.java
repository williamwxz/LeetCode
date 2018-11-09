/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    //1. Map<slope, # of points>
    //2. for each point, find max point in the line
    //3. be careful with point align as veritical line
    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n<=1){
            return n;
        }
        int max = 0;
        for (int i=0; i<n; i++){
            Point pivot = points[i];
            Map<String, Integer> map = new HashMap<>();
            int sameX=0, samePoint=1, maxPoints=0;
            for (int j=i+1; j<n; j++){
                if (points[j].x==pivot.x&&points[j].y==pivot.y){
                    samePoint++;
                }else if (points[j].x==pivot.x){
                    sameX++;
                }else{
                    //get their most common divisor, x must not be zero
                    int x = pivot.x-points[j].x;
                    int y = pivot.y-points[j].y;
                    int divisor = gcd(y,x);
                    String slope = (y/divisor)+"/"+(x/divisor);
                    map.put(slope, map.getOrDefault(slope, 0)+1);
                    int p = map.get(slope);
                    maxPoints = Math.max(maxPoints, p);
                }
            }
            maxPoints = Math.max(maxPoints, sameX);
            max = Math.max(max, maxPoints+samePoint);
        }
        return max;
    }
    private int gcd(int a, int b){
        //a is divisale by b, return b
        while (a%b!=0){
            int tmp=b;
            b = a%b;
            a = tmp;
        }
        return b;
    }
}