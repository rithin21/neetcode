class Solution {
public:

void dfs(int r,int c,vector<vector<int>>&heights,vector<vector<bool>>&visited)
{
    visited[r][c]=true;
    int rows=heights.size();
    int cols=heights[0].size();

    vector<vector<int>>dirs={{0,1},{0,-1},{1,0},{-1,0}};

    for(auto&d:dirs)
    {
        int nr=r+d[0];
        int nc=c+d[1];

        if(nr<0||nc<0||nr>=rows||nc>=cols)
        {
            continue;
        }
        if(visited[nr][nc])
        {
            continue;
        }
        if(heights[nr][nc]>=heights[r][c])
        {
            dfs(nr,nc,heights,visited);
        }
    }
}

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int rows=heights.size();
        int cols=heights[0].size();

        vector<vector<bool>>pacific(rows,vector<bool>(cols,false));
        vector<vector<bool>>atlantic(rows,vector<bool>(cols,false));

        for(int c=0;c<cols;c++)
        {
            dfs(0,c,heights,pacific);
        }
        for(int r=0;r<rows;r++)
        {
            dfs(r,0,heights,pacific);
        }
        for(int c=0;c<cols;c++)
        {
            dfs(rows-1,c,heights,atlantic);
        }
        for(int r=0;r<rows;r++)
        {
            dfs(r,cols-1,heights,atlantic);
        }

        vector<vector<int>>result;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(pacific[r][c]&&atlantic[r][c])
                {
                    result.push_back({r,c});
                }
            }
        }
        return result;
    }
};
