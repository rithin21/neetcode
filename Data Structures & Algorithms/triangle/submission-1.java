class Solution {
    Integer[][]dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=m;
        dp=new Integer[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        return rec_call(triangle,0,0);
    }

    public int rec_call(List<List<Integer>>triangle,int row,int col){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        
        int left=rec_call(triangle,row+1,col);
        int right=rec_call(triangle,row+1,col+1);

        dp[row][col]=triangle.get(row).get(col)+Math.min(left,right);
        return dp[row][col];
    }


}