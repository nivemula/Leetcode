class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int sum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if (node == null) return;

        // choose
        path.add(node.val);
        sum -= node.val;

        // check if leaf & sum matched
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(path)); // important copy
        }

        // explore
        dfs(node.left, sum, path, result);
        dfs(node.right, sum, path, result);

        // un-choose (backtrack)
        path.remove(path.size() - 1);
    }
}