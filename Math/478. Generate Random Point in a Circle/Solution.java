class Solution {
    private double radius, x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
        double[] res=new double[2];
        while (true){
            double x=Math.random()*2*radius-radius;
            double y=Math.random()*2*radius-radius;
            double range=Math.pow(radius, 2);
            if (Math.pow(x-x_center, 2)+Math.pow(y-y_center, 2)<=range){
                res[0]=x;
                res[1]=y;
                break;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */