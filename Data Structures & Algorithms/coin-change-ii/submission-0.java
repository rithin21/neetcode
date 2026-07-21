class Solution {
    Integer[][]dp;
    public int change(int amount, int[] coins) {
        dp=new Integer[amount+1][coins.length];
        return rec(amount,0,coins);
    }

    private int rec(int rem,int index,int[]coins){
        if(rem==0){
            return 1;
        }
        if(rem<0){
            return 0;
        }
        if(index==coins.length){
            return 0;
        }
        if(dp[rem][index]!=null){
            return dp[rem][index];
        }

        int take=rec(rem-coins[index],index,coins);
        int skip=rec(rem,index+1,coins);

        return dp[rem][index]=take+skip;
    }
}
