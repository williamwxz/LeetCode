class StockSpanner {
    Deque<int[]> stack;//value:existance
    public StockSpanner() {
        stack=new ArrayDeque<>();
    }
    
    public int next(int price) {
        int res=1;
        while (!stack.isEmpty()&&stack.peekLast()[0]<=price){
            res+=stack.pollLast()[1];
        }
        stack.offerLast(new int[]{price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */