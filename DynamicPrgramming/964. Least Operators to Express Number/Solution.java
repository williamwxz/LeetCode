class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int pos=0, neg=0;
        int i=0;
        while (target>0){
            int cur=target%x;
            target/=x;
            if (i==0){
                pos=cur*2;
                neg=(x-cur)*2;
            }else{
                int tmp_p=Math.min(cur*i+pos, (cur+1)*i+neg);
                int tmp_n=Math.min((x-cur)*i+pos, (x-cur-1)*i+neg);
                pos=tmp_p;
                neg=tmp_n;
            }
            i++;
        }
        return Math.min(pos-1, neg+i-1);
    }
}