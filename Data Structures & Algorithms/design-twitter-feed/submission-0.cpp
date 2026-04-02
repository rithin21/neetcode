class Twitter {
    private:
    vector<pair<int,int>>tweets;
    unordered_map<int,unordered_set<int>>following;
public:
    Twitter() {
        
    }
    
    void postTweet(int userId, int tweetId) {
        tweets.push_back({userId,tweetId});
    
    }
    
    vector<int> getNewsFeed(int userId) {
        vector<int>feed;
        int count=0;
        for(int i=tweets.size()-1;i>=0&&count<10;i--)
        {
            int tweetUser=tweets[i].first;
            int tweetId=tweets[i].second;

            if(tweetUser==userId||following[userId].count(tweetUser))
            {
                feed.push_back(tweetId);
                count++;
            }
        }
        return feed;
        
    }
    
    void follow(int followerId, int followeeId) {
        if(followerId!=followeeId)
        {
            following[followerId].insert(followeeId);
        }
        
    }
    
    void unfollow(int followerId, int followeeId) {
        following[followerId].erase(followeeId);
        
    }
};
