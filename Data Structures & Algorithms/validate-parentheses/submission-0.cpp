class Solution {
public:
    bool isValid(string s) {
        unordered_map<char,char>matching_pair={{')','('},{']','['},{'}','{'}};
        stack<char>opening;
        for(char c:s)
        {
            if(matching_pair.count(c)!=0)
            {
                if(opening.empty()||matching_pair[c]!=opening.top())
                {
                    return false;
                }
                opening.pop();
            }
            else
            {
                opening.push(c);
            }
            
        }
        return opening.empty();
        
    }
};
