class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i=n-1; i>=0; i--){
            if (queue.size()>0){
                queue.offer(queue.poll());
            }
            queue.offer(deck[i]);
        }
        for (int i=n-1; i>=0; i--){
            result[i]=queue.poll();
        }
        return result;
    }
}