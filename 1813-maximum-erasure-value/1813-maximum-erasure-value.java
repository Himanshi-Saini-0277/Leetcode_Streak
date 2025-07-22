import java.util.HashSet;
import java.util.Set;

class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    int left = 0, currentSum = 0, maxSum = 0;

    for (int right = 0; right < nums.length; right++) {
      while (seen.contains(nums[right])) {
        seen.remove(nums[left]);
        currentSum -= nums[left];
        left++;
      }
      seen.add(nums[right]);
      currentSum += nums[right];
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }
}