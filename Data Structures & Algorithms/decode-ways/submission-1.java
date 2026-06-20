class Solution {
    Integer[]dp;
    public int numDecodings(String s) {
        dp=new Integer[s.length()+1];
        return dfs(0,s); 
    }

    public int dfs(int index,String s)
    {
        if (dp[index] != null)
            return dp[index];

        if(index==s.length())
        {
            return 1;
        }
        if(s.charAt(index)=='0')
        {
            return 0;
        }
        int ways=dfs(index+1,s);
        if(index+1<s.length())
        {
            int num=((s.charAt(index)-'0')*10)+(s.charAt(index+1)-'0');
            if (num >= 10 && num <= 26) {
                ways += dfs(index + 2, s);
            }
        }
        return dp[index]=ways;
    }
}
