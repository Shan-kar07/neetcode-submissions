class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time,int tweetId){
        this.time=time;
        this.tweetId=tweetId;
    }
    public int compareTo(Tweet that){
        return that.time-this.time;
    }
}

class User{
    int userId;
    List<Tweet> tweets;
    HashSet<Integer> follweers;

    User(int userId){
        this.userId=userId;
        follweers=new HashSet<>();
        follweers.add(userId);
        tweets=new LinkedList<>();
    }

    public void addTweet(Tweet t){
        tweets.add(0,t);
    }
    public void addFollower(int followee){
        follweers.add(followee);
    }
    public void removeFollower(int followee){
        follweers.remove(followee);
    }
}


class Twitter {
    HashMap<Integer,User> userMap;
    int timeCounter;
    public Twitter() {
        userMap=new HashMap<>();
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user=userMap.get(userId);
        user.addTweet(new Tweet(timeCounter,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq=new PriorityQueue<>();

        User user=userMap.get(userId);

        for(int followerId : user.follweers){
            int count=0;
            for(Tweet tweet :userMap.get(followerId).tweets){
                pq.offer(tweet);
                count++;
                if(count>10){
                    break;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        int index=0;
        while(!pq.isEmpty()&&index<10){
            Tweet tweet=pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
         if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User user=userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followeeId) ||!userMap.containsKey(followerId) ){
            return;
        }
        if(followerId == followeeId){
        return;
    }
        User user=userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}
