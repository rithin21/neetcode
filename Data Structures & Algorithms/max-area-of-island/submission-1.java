class Solution {
    int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};

    int dfs(int[][]grid,int r,int c)
    {
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0)
        {
            return 0;
        }
        grid[r][c]=0;
        int area=1;
        for(int i=0;i<4;i++)
        {
            area+=dfs(grid,r+directions[i][0],c+directions[i][1]);
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int area=0;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c]==1)
                {
                    area=Math.max(area,dfs(grid,r,c));
                }
                
            }
        }
        return area;
        
        
    }
}
