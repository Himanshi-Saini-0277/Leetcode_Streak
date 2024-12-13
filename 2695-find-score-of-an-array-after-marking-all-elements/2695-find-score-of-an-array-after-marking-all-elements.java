class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && nums[i] >= q.peekLast()) {
                boolean skip = false;
                while (!q.isEmpty()) {
                    int add = q.pollLast();
                    if (!skip) {
                        score += add;
                    }
                    skip = !skip;
                }
                continue;
            }

            q.addLast(nums[i]);
        }

        boolean skip = false;
        while (!q.isEmpty()) {
            int add = q.pollLast();
            if (!skip) {
                score += add;
            }
            skip = !skip;
        }

        return score;
    }
}