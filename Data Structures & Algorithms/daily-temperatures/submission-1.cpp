class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int>temp;
        vector<int>result;
        for(int i=temperatures.size()-1;i>=0;i--)
        {
            while(temp.empty()==false&&temperatures[temp.top()]<=temperatures[i])
            {
                temp.pop();    
            }
            if (temp.empty()) {
                result.push_back(0);
            } else {
                result.push_back(temp.top() - i);
            }

            temp.push(i);
        }
        reverse(result.begin(),result.end());
        return result;
    }
};
