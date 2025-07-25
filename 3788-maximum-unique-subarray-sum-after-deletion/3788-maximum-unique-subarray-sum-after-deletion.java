class Solution {
    public int maxSum(int[] nums) {
        int mn = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        int sum = 0;

        for (int val : nums) {
            if (!set.contains(val)) {
                if (val >= 0) {
                    sum += val;
                } else {
                    mn = Math.max(mn, val);
                }
            }

            set.add(val);
        }

        if (sum == 0 && !set.contains(0)) {
            return mn;
        }

        return sum;
    }
}