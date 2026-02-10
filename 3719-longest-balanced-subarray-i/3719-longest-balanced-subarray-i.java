class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int[] balance = new int[n];
        HashMap<Integer, Integer> first = new HashMap<>();

        int result = 0;
        for (int l = n - 1; l >= 0; l--) {
            int x = nums[l];

            Integer oldpos = first.get(x);
            if (oldpos != null)
                balance[oldpos] = 0;

            first.put(x, l);
            balance[l] = ((x & 1) == 0) ? 1 : -1;

            int s = 0;
            for (int r = l; r < n; r++) {
                s += balance[r];
                if (s == 0)
                    result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }
}