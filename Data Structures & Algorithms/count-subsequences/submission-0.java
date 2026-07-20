class Solution {
    int[][]dp;
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
            
        }
        return rec(s,t,0,0);
        
    }

    public int rec(String s,String t,int start,int index){
        if(index==t.length()){
            return 1;
        }
        if(start==s.length()){
            return 0;
        }
        if(dp[start][index]!=-1){
            return dp[start][index];
        }
        int ans=0;
        if (s.charAt(start) == t.charAt(index)) {
            ans += rec(s,t,start+1,index+1);
            ans += rec(s,t,start+1,index);
        } else {
            ans = rec(s,t,start+1,index);
        }

        return dp[start][index] = ans;
    }
}
