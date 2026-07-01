class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // left -> right
            for (int col = left; col <= right; col++)
                ans.add(matrix[top][col]);
            top++;

            // top -> bottom
            for (int row = top; row <= bottom; row++)
                ans.add(matrix[row][right]);
            right--;

            // right -> left
            if (top <= bottom) {
                for (int col = right; col >= left; col--)
                    ans.add(matrix[bottom][col]);
                bottom--;
            }

            // bottom -> top
            if (left <= right) {
                for (int row = bottom; row >= top; row--)
                    ans.add(matrix[row][left]);
                left++;
            }
        }

        return ans;
    }
}