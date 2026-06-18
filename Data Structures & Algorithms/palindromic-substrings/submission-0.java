class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            ans+=count(s,i,i);
            ans+=count(s,i,i+1);
        }
        return ans;
        
    }

    public int count(String s,int l,int r)
    {
        int c=0;
        while(l>=0 &&r<s.length() &&s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
            c++;
        }
        return c;
    }
}
