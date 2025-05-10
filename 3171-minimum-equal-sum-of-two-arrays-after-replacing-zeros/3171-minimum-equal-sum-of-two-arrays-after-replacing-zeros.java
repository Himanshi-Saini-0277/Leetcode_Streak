class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zero1++;
                sum1 += 1;
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                zero2++;
                sum2 += 1;
            } else {
                sum2 += num;
            }
        }

        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}