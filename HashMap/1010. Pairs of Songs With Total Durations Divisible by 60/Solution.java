class Solution {
    public int numPairsDivisibleBy60(int[] times) {
        int res=0;
        int[] count=new int[60];
        for (int time:times){
            res+=count[(60-time%60)%60];
            count[(time%60)]+=1;
        }
        return res;
    }
}