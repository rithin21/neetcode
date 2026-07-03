class Solution {

    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // Left and Right boundaries
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, visited, i, n - 1);
            }
        }

        // Top and Bottom boundaries
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, visited, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, visited, m - 1, j);
            }
        }

        // Flip all unvisited O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col) {

        int m = board.length;
        int n = board[0].length;

        // Out of bounds
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        // Already visited
        if (visited[row][col]) {
            return;
        }

        // Hit an X
        if (board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true;

        for (int[] dir : directions) {
            dfs(board, visited, row + dir[0], col + dir[1]);
        }
    }
}