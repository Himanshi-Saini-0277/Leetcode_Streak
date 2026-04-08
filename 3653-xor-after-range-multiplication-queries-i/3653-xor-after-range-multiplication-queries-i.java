class Solution {
    final int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        // Process each query
        for (int[] t : queries) {
            int l = t[0];
            int r = t[1];
            int k = t[2];
            int v = t[3];

            int idx = l;

            // Apply operation at step k
            while (idx <= r) {
                long temp = nums[idx];
                nums[idx] = (int)((temp * v) % mod);
                idx += k;
            }
        }

        // Compute XOR of final array
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}