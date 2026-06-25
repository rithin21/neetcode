class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int lower, int upper) {

        if(root == null) {
            return true;
        }

        if(root.val <= lower || root.val >= upper) {
            return false;
        }

        return helper(root.left, lower, root.val)
            && helper(root.right, root.val, upper);
    }
}