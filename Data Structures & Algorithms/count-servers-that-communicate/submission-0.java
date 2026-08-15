class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count servers in each row and column
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int ans = 0;

        // A server communicates if there is
        // another server in its row OR column.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 &&
                    (rowCount[row] > 1 || colCount[col] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}