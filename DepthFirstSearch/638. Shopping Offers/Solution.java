class Solution {
    public int shoppingOffers(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {
        return dfs(prices, specials, needs, 0);
    }
    private int dfs(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs, int start) {
        int cost=0;
        int n = prices.size();
        for (int i=0; i<n; i++){
            cost+=needs.get(i)*prices.get(i);
        }
        if (cost==0){
            return 0;
        }
        for (int j=start; j<specials.size(); j++){
            List<Integer> offer=specials.get(j);
            List<Integer> next=new ArrayList<>();
            for (int i=0; i<n; i++){
                if (offer.get(i)>needs.get(i)){
                    next=null;
                    break;
                }
                next.add(needs.get(i)-offer.get(i));
            }
            if (next!=null){
                cost=Math.min(cost, dfs(prices, specials, next, j)+offer.get(n));
            }
        }
        return cost;
    }
}