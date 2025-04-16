class Solution 
{
    public long countGood(int[] nums, int k) 
    {
        int n = nums.length;
        int i = 0, j = 0;
        long result = 0, pairs = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n) 
        {
            pairs += map.getOrDefault(nums[j], 0);

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (pairs >= k) 
            {
                result += (n - j);

                map.put(nums[i], map.get(nums[i]) - 1);
                pairs -= map.get(nums[i]); 
                i++;
            }

            j++;
        }

        return result;
    }
}