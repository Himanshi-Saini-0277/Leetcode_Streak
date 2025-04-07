class Solution {
    private int sumOf(int[] nums)
    {
        int sum = 0;
        for(int num:nums)
        sum += num;
        return sum;
    }
    private boolean rec(int i,int[] nums,int n,int sum,int[][] dp)
    {
        if(sum == 0) return true;
        if(0 > sum || i>=n) return false;
        if(dp[i][sum] != -1) return dp[i][sum] == 0 ? false: true;

        boolean dont = rec(i+1,nums,n,sum,dp);
        boolean pick = false;
        if(nums[i]<=sum) pick = rec(i+1,nums, n,sum-nums[i],dp);
        dp[i][sum] = (pick || dont) ? 1: 0;
        return pick || dont;

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = sumOf(nums);
        if((sum & 1) == 1) return false;
        sum = sum/2;
        int[][] dp = new int[n][sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return rec(0,nums,n,sum,dp);
    }
}