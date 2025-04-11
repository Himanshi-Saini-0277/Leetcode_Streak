
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            String s = Integer.toString(num);
            int len = s.length();
            if (len % 2 != 0) continue;

            int mid = len / 2;
            int leftSum = 0, rightSum = 0;

            for (int i = 0; i < mid; i++) {
                leftSum += s.charAt(i) - '0';
                rightSum += s.charAt(i + mid) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }
}
