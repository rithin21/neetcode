class Solution {

    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Pair>locations=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    locations.add(new Pair(i,j));
                }
            }
        }

        for(Pair x:locations){
            int row=x.row;
            int col=x.col;

            for(int i=0;i<m;i++)
            {
                matrix[i][col]=0;
            }
            for(int j=0;j<n;j++)
            {
                matrix[row][j]=0;
            }

        }



        
    }
}
