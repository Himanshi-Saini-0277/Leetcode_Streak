class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;

        int[][] dp0 = new int[zero + 1][one + 1];
        int[][] dp1 = new int[zero + 1][one + 1];

        for (int i = 1; i <= Math.min(zero, limit); ++i) dp0[i][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); ++j) dp1[0][j] = 1;

        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                for (int k = 1; k <= Math.min(limit, i); ++k)
                    dp0[i][j] = (dp0[i][j] + dp1[i - k][j]) % mod;
                for (int k = 1; k <= Math.min(limit, j); ++k)
                    dp1[i][j] = (dp1[i][j] + dp0[i][j - k]) % mod;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % mod;
    }
}