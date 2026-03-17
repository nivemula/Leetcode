import java.util.*;

class Solution {

    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Step 1: map inorder values to index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        if (left > right) return null;

        // Step 2: root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Step 3: find in inorder
        int index = map.get(rootVal);

        // Step 4: build RIGHT first
        root.right = build(inorder, postorder, index + 1, right);

        // Step 5: build LEFT
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}