class Solution {
public:
int count=0;
    int orangesRotting(vector<vector<int>>& grid) 
    {
        vector<vector<int>>dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int m=grid.size();
        int n=grid[0].size();
        int fresh=0;
        queue<pair<int,int>>q;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.push({i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        if(fresh==0)
        {
            return 0;
        }

        int minutes=-1;
        while(q.empty()==false)
        {
            int size=q.size();
            minutes++;
            while(size--)
            {
                int row=q.front().first;
                int col=q.front().second;
                q.pop();
            

                for(int i=0;i<4;i++)
                {
                    int r=row+dirs[i][0];
                    int c=col+dirs[i][1];

                if(r<0||c<0||r>=grid.size()||c>=grid[0].size()||grid[r][c]==0||grid[r][c]==2)
                {
                    continue;
                }
                grid[r][c]=2;
                fresh--;
                q.push({r,c});
                }
            }
            
        }
        if(fresh>0)
        {
            return -1;
        }
        return minutes;
    }
    
};
