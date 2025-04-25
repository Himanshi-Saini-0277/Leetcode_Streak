class Solution 
{
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) 
    {
        long result = 0;
        int prefix = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);

        for (int num : nums) 
        {
            if (num % modulo == k) 
            {
                prefix++;
            }

            int mod = prefix % modulo;
            int target = (mod - k + modulo) % modulo;

            result += map.getOrDefault(target, 0L);
            map.put(mod, map.getOrDefault(mod, 0L) + 1);
        }

        return result;
    }
}