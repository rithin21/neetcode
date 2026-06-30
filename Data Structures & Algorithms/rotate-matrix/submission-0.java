class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int col=0; col<n; col++)
        {
            for(int row=0; row<n/2; row++)
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n-row-1][col];
                matrix[n-row-1][col] = temp;
            }
        }
        for(int row=1;row<n;row++)
        {
            for(int col=0;col<row;col++)
            {
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
        
    }
}
