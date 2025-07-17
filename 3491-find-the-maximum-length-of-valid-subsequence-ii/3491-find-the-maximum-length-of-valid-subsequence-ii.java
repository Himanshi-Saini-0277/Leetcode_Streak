public class Solution 
{
    public int maximumLength(int[] nums, int k) 
    {
        int[][] dp = new int[k][k];
        int maxLength = 0;

        for (int num : nums) 
        {
            int current_rem = num % k;

            for (int prev_rem = 0; prev_rem < k; prev_rem++) 
            {
                dp[prev_rem][current_rem] = dp[current_rem][prev_rem] + 1;

                if (dp[prev_rem][current_rem] > maxLength) 
                {
                    maxLength = dp[prev_rem][current_rem];
                }
            }
        }

        return maxLength;
    }
}