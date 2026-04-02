class Solution {
public:
int rows,cols;
    void solve(vector<vector<char>>& board) {
        rows=board.size();
        cols=board[0].size();
        for(int r=0;r<rows;r++)
        {
            if(board[r][0]=='O')
            {
                markts(board,r,0);
            }

            if(board[r][cols-1]=='O')
            {
                markts(board,r,cols-1);
            }
        }
        for(int c=0;c<cols;c++)
        {
            if(board[0][c]=='O')
            {
                markts(board,0,c);
            }

            if(board[rows-1][c]=='O')
            {
                markts(board,rows-1,c);
            }
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                else if(board[i][j]=='T')
                {
                    board[i][j]='O';
                }
            }
        }
        
    }

    void markts(vector<vector<char>>&board,int r,int c)
    {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O')
        {
            return;
        }

        board[r][c]='T';
        markts(board,r+1,c);
        markts(board,r-1,c);
        markts(board,r,c+1);
        markts(board,r,c-1);
    }
};
