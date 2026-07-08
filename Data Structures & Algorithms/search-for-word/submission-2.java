class Solution {
    int[][]directions={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        char[]letters=word.toCharArray();
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int row=0;row<m;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(board[row][col]==letters[0])
                {
                    if(search(0,board,letters,row,col,m,n,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    public boolean search(int index,char[][]board,char[]letters,int row,int col,int m,int n,boolean[][]visited){
        if(visited[row][col])
        return false;

        if(board[row][col]!=letters[index])
            return false;

        if(index==letters.length-1)
            return true;
            
        visited[row][col]=true;
        for(int[]x:directions){
            if(row+x[0]<0||row+x[0]>=m||col+x[1]<0||col+x[1]>=n)
            {
                continue;
            }
            if(search(index+1,board,letters,row+x[0],col+x[1],m,n,visited)){
                return true;
            }
        }
        visited[row][col]=false;
        return false;
    }
}
