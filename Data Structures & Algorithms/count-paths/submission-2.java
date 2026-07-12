class Solution {
    int [][]dp;
    public int countpath(int m,int n,int row,int col){
        if(row==m-1&&col==n-1){
            return 1;
        }
        if(row>=m||col>=n){
            return 0;
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        return dp[row][col]=countpath(m,n,row+1,col)+countpath(m,n,row,col+1);
    }

    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        return countpath(m,n,0,0);
    }
}
