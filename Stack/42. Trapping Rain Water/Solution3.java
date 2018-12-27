class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total=0;
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0; i<n; i++){
            while (!stack.isEmpty()&&height[stack.peekLast()]<height[i]){
                int level=height[stack.pollLast()];
                if (stack.isEmpty()){
                    break;
                }
                int left=stack.peekLast();
                total+=(i-left-1)*(Math.min(height[left], height[i])-level);
            }
            stack.offerLast(i);
        }
        return total;
    }
}