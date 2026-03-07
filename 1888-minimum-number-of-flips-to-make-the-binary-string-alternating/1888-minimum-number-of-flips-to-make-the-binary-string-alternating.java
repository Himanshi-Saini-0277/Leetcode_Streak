class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            char expect1 = (i % 2 == 0) ? '0' : '1'; // 0101...
            char expect2 = (i % 2 == 0) ? '1' : '0'; // 1010...

            if (t.charAt(i) != expect1) diff1++;
            if (t.charAt(i) != expect2) diff2++;

            if (i >= n) {
                char oldExpect1 = ((i - n) % 2 == 0) ? '0' : '1';
                char oldExpect2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (t.charAt(i - n) != oldExpect1) diff1--;
                if (t.charAt(i - n) != oldExpect2) diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}