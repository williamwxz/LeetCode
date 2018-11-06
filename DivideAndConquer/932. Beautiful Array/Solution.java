class Solution {
    public int[] beautifulArray(int N) {
        int[] result = new int[N];
        beautifulArray(result, 0, N, 1, 1);
        return result;
    }
    // right is exclusive
    private void beautifulArray(int[] result, int left, int right, int start, int steps){
        if (left>=right){
            return;
        }
        int len = right-left;
        if (len==1){
            result[left]=start;
        }else if (len==2){
            result[left]=start;
            result[left+1]=start+steps;
        }else{
            int mid = (len+1)/2+left;
            beautifulArray(result, left, mid, start, steps<<1);
            beautifulArray(result, mid, right, start+steps, steps<<1);
        }
    }
}