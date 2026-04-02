#include<unordered_set>

class Solution 
{
public:
    bool isAnagram(string s, string t) 
    {
        if (s.length() != t.length()) {
            return false;
        }
        unordered_map<char,int>ss;
        unordered_map<char,int>tt;
        for(int i=0;i<s.length();i++)
        {
            ss[s[i]]++;
            tt[t[i]]++;
        }
        return ss==tt;
    }
};
