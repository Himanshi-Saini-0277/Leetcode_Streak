/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class FindElements {
    BitSet recoveredValues;

    public FindElements(TreeNode root) {
        root.val = 0;
        recoveredValues = new BitSet();
        recoverTree(root);
    }

    private void recoverTree(TreeNode root) {
        if (root == null) return;
        recoveredValues.set(root.val);
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            recoverTree(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            recoverTree(root.right);
        }
    }

    public boolean find(int target) {
        return recoveredValues.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */