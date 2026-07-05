class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int top=0;
        int bottom=rows-1;
        while(top<=bottom)
        {
            int mid=top+(bottom-top)/2;

            if(target<matrix[mid][0])
            {
                bottom=mid-1;
            }
            else if(target>matrix[mid][cols-1])
            {
                top=mid+1;
            }
            else if(target>=matrix[mid][0] && target<=matrix[mid][cols-1])
            {
                return horizontal_bsearch(matrix,mid,target,cols);
            }
        }
        return false;
    }

    public boolean horizontal_bsearch(int [][]matrix,int mid,int target,int cols){
        int left=0;
        int right=cols-1;
        while(left<=right)
        {
            int midc=left+(right-left)/2;
            if(target==matrix[mid][midc])
            {
                return true;
            }
            else if(target<matrix[mid][midc])
            {
                right=midc-1;
            }
            else
            {
                left=midc+1;
            }
        }
        return false;
    }
}
