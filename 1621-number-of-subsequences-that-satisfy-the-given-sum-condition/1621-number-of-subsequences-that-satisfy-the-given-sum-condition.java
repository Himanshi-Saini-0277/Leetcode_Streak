public class Solution 
{
    public int numSubseq(int[] nums, int target) 
    {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        Arrays.sort(nums);

        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) 
        {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = n - 1;
        int result = 0;

        while (left <= right) 
        {
            if (nums[left] + nums[right] <= target) 
            {
                result = (result + powers[right - left]) % MOD;
                left++;
            } 
            else 
            {
                right--;
            }
        }

        return result;
    }
}