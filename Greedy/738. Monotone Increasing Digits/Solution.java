class Solution {
    // 332
    // since 3 is larger than 2, make 3 to 2, and 2 to 9
    // idea is, once found, decrease, decrement, and make remaining to 9
    public int monotoneIncreasingDigits(int N) {
        char[] array = Integer.toString(N).toCharArray();
        int n = array.length;
        int remain=n;
        for (int i=n-1; i>0; i--){
            if (array[i-1]>array[i]){
                array[i-1]--;
                remain = i;
            }
        }
        for (int j=remain; j<n; j++){
            array[j]='9';
        }
        return Integer.parseInt(new String(array));
    }
}