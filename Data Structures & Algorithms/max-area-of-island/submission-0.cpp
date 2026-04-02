class Solution {
public:
    int directions[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};

    int maxAreaOfIsland(vector<vector<int>>& grid) 
    {
        int rows = grid.size();
        int cols = grid[0].size();
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {               // start DFS only on land
                    int area = dfs(grid, r, c, rows, cols);
                    maxArea = max(maxArea, area);    // keep track of best
                }
            }
        }
        return maxArea;
    }

    int dfs(vector<vector<int>>& grid, int r, int c, int rows, int cols)
    {
        // out of bounds or water → contributes 0 area
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;      // mark as visited (turn land to water)
        int area = 1;        // count current cell

        for (int i = 0; i < 4; i++) {
            int nr = r + directions[i][0];
            int nc = c + directions[i][1];
            area += dfs(grid, nr, nc, rows, cols);
        }
        return area;
    }
};
