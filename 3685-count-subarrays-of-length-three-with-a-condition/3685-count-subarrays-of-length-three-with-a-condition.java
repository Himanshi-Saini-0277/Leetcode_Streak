class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];

            if (first + third == middle / 2.0) {
                count++;
            }
        }

        return count;
    }
}