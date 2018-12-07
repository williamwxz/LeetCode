class Twitter {
    private static int timestamp=0;
    class Tweet{
        int time;
        int id;
        public Tweet(int id){
            time = timestamp++;
            this.id = id;
            Tweet next = null;
        }
    }
    class User{
        int id;
        Set<Integer> following;
        Tweet head;
        public User(int id){
            this.id=id;
            following = new HashSet<>();
            head = null;
            follow(id);//follow self first
        }
        public void follow(int followeeId){
            following.add(followeeId);
        }
        public void unfollow(int followeeId){
            following.remove(followeeId);
        }
        public void post(int tweetId){
            Tweet cur = new Tweet(tweetId);
            cur.next = head;
            head = cur;
        }
    }
    private Map<Integer, User> map;
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)){
            map.put(userId, new User(userId));
        }
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!map.containsKey(userId)){
            return result;
        }
        PriorityQueue pq = new PriorityQueue<>(new Comparator<Tweet>(){
            @Override
            public int compare(Tweet t1, Tweet t2){
                return t2.time-t1.time;
            }
        });
        for (int user:map.get(userId).following){
            Tweet tweet = map.get(user).head;
            if (tweet!=null){
                pq.add(tweet);
            }
        }
        while (pq.size()>0&&result.size()<10){
            Tweet tweet = pq.poll;
            result.add(tweet.id);
            if (tweet.next!=null){
                pq.add(tweet.next);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)){
            map.put(followerId, new User(userId));
        }
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)){
            map.put(userId, new User(userId));
        }
        map.get(userId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */