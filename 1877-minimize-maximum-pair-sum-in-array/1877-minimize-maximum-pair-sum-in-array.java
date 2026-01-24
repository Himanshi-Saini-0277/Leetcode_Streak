class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] freq = new int[100001];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
            freq[nums[i]]++;
        }
        int max_sum = 0, l = min, r = max;
        while(l <= r) {
            if(freq[l] == 0) l++;
            else if(freq[r] == 0) r--;
            else {
                max_sum = Math.max(max_sum, l + r);
                freq[l]--;
                freq[r]--;
            }
        }
        return max_sum;
    }
}