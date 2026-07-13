class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }

        return ans;
    }

    private int dfs(int row, int col, int[][] matrix) {

        // Already computed
        if(dp[row][col] != 0) {
            return dp[row][col];
        }

        // Path containing only this cell
        int maxLength = 1;

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < matrix.length &&
               newCol >= 0 && newCol < matrix[0].length &&
               matrix[newRow][newCol] > matrix[row][col]) {

                maxLength = Math.max(maxLength,
                                     1 + dfs(newRow, newCol, matrix));
            }
        }

        dp[row][col] = maxLength;
        return maxLength;
    }
}