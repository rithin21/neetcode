class Solution {

    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};

    void dfs(char[][]grid,int r,int c)
    {
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]=='0')
        {
            return;
        }
        grid[r][c]='0';
        for(int i=0;i<4;i++)
        {
            dfs(grid,r+directions[i][0],c+directions[i][1]);
        }
    }


    public int numIslands(char[][] grid) {
        int islands=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c]=='1')
                {
                    islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return islands;
        
    }
}
