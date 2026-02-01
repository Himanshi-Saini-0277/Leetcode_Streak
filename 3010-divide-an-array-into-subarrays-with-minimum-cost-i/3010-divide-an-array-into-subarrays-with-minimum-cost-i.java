class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];

        Arrays.sort(nums, 1, nums.length);

        return first + nums[1] + nums[2];
    }
}