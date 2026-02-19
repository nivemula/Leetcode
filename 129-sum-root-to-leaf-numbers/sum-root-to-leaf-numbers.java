class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        // If leaf node → return formed number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Sum from left and right
        return dfs(node.left, currentSum) + 
               dfs(node.right, currentSum);
    }
}