class Solution {
    int[][]board;
    List<List<String>>ans_m=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        board=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        rec_call(n,0);
        return ans_m;  
    }

    public void stringify(){
        ArrayList<String>ans=new ArrayList<>();
        for(int x[]:board){
            StringBuilder sb=new StringBuilder();
            for(int y:x){
                if(y==0){
                    sb.append(".");
                }
                else{
                    sb.append("Q");
                }
            }
            ans.add(sb.toString());
        }
        ans_m.add(ans);
    }

    public boolean check(int row,int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]==1){
                return false;
            }
        }
        int c_row=row;
        int c_col=col;
        while(c_row>=0&&c_col<n){
            if(board[c_row][c_col]==1){
                return false;
            }
            c_row--;
            c_col++;
        }

        c_row=row;
        c_col=col;
        while(c_row>=0&&c_col>=0){
            if(board[c_row][c_col]==1){
                return false;
            }
            c_row--;
            c_col--;
        }
        return true;

    }

    public void rec_call(int n,int row){
        if(row==n){
            stringify();
            return;
        }
        for(int col=0;col<n;col++){
            if(check(row,col,n))
            {
                board[row][col]=1;
                rec_call(n,row+1);
                board[row][col]=0;
            }
        }
    }
}
