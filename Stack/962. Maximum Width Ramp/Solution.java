class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0; i<n; i++){
            if (stack.isEmpty() || A[stack.peekLast()]>A[i]){
                stack.offerLast(i);
            }
        }
        int result=0;
        for (int i=n-1; i>=0; i--){
            while (!stack.isEmpty()&&A[i]>=A[stack.peekLast()]){
                result=Math.max(result, i-stack.pollLast());
            }
        }
        return result;
    }
}