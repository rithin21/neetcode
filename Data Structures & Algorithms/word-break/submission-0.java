class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>worddict=new HashSet<>(wordDict);
        Boolean dp[]=new Boolean[s.length()];
        if(dfs(0,s,dp,worddict))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public boolean dfs(int start,String s,Boolean dp[],HashSet<String>worddict)
    {
        if(start==s.length())
        {
            return true;
        }
        if(dp[start] != null) 
        {
            return dp[start];
        }
        for(int end=start+1;end<=s.length();end++)
        {
            if(worddict.contains(s.substring(start,end)))
            {
                if(dfs(end,s,dp,worddict))
                {
                    dp[start]=true;
                    return true;
                }
            }
        }
        dp[start]=false;
        return false;
    }
}
