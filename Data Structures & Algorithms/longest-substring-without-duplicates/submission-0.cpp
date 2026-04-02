class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int>freq;
        int n=s.size();
        int l=0;
        int r=0;
        int maxlen=0;
        while(r<n)
        {
            freq[s[r]]++;
            while(freq[s[r]]>1)
            {
                freq[s[l]]--;
                l++;
            }
            maxlen=max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
        
    }
};
