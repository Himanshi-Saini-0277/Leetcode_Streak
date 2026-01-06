class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int max_sum = Integer.MIN_VALUE, max_lvl = 1, curr_lvl = 1;

        while (!q.isEmpty()) {
            int lvl_size = q.size(), lvl_sum = 0;

            for (int i = 0; i < lvl_size; i++) {
                TreeNode node = q.poll();
                lvl_sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (lvl_sum > max_sum) {
                max_sum = lvl_sum;
                max_lvl = curr_lvl;
            }
 
            curr_lvl++;
        }

        return max_lvl;
    }
}