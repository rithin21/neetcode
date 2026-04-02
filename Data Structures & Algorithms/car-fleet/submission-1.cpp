class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,int>>paired;
        stack<double>st;
        int n=position.size();
        for(int i=0;i<n;i++)
        {
            paired.push_back({position[i],speed[i]});
        }
        sort(paired.begin(),paired.end());
        for(int i=n-1;i>=0;i--)
        {
            double time = (double)(target - paired[i].first) / paired[i].second;
            if (st.empty() || time > st.top())

            {
                st.push(time);
            }   
        }
        return st.size();
        
    }
};
