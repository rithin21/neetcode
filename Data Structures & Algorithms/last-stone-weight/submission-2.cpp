#include<queue>

class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int>s(stones.begin(),stones.end());
        while(s.size()>1)
        {
            int y=s.top();
            s.pop();
            int x=s.top();
            s.pop();

            if(y!=x)
            {
                s.push(y-x);
            }    
        }
        if(s.empty())
        {
            return 0;
        }
        return s.top();
    }
};
