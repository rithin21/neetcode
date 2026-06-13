class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int []freq=new int[128];
        int maxlen=0;
        while(r<s.length())
        {
            char ch=s.charAt(r);
            freq[ch]++;
            
            if(freq[ch]>1)
            {
                while(freq[ch]>1)
                {
                    char rem=s.charAt(l);
                    freq[rem]--;
                    l++;
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
        
    }
}
