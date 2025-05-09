class Solution 
{
    public int countBalancedPermutations(String num) 
    {
        int[] f = new int[10]; 
        
        int s = 0;

        for (char c : num.toCharArray()) 
        {
            f[c - '0']++;
            s += c - '0';
        }

        if (s % 2 != 0) 
        {
            return 0;
        }

        final int mod = 1000000007;
        
        s /= 2; 
        
        int n = num.length();

        long[][] dp = new long[n / 2 + 1][s + 1];
        int[][] fif = enumFIF(1000, mod);
        dp[0][0] = (long) fif[0][n / 2] * fif[0][n - n / 2] % mod;

        for (int i = 0; i <= 9; i++) 
        {
            long[][] ndp = new long[n / 2 + 1][s + 1];

            for (int j = n / 2; j >= 0; j--) 
            {
                for (int k = s; k >= 0; k--) 
                {
                    if (dp[j][k] == 0)
                    {
                        continue;
                    }

                    for (int t = 0; t <= f[i] && k + i * t <= s && j + t <= n / 2; t++) 
                    {
                        long add = dp[j][k] * fif[1][t] % mod * fif[1][f[i] - t] % mod;
                        ndp[j + t][k + i * t] = (ndp[j + t][k + i * t] + add) % mod;
                    }
                }
            }

            dp = ndp;
        }

        return (int) dp[n / 2][s];
    }

    public static int[][] enumFIF(int n, int mod) 
    {
        int[] f = new int[n + 1];
        int[] invf = new int[n + 1];

        f[0] = 1;
        for (int i = 1; i <= n; i++) 
        {
            f[i] = (int) ((long) f[i - 1] * i % mod);
        }

        long a = f[n], b = mod;
        long p = 1, q = 0;
        while (b > 0) 
        {
            long c = a / b, d;
            d = a; a = b; b = d % b;
            d = p; p = q; q = d - c * q;
        }

        invf[n] = (int) (p < 0 ? p + mod : p);
        for (int i = n - 1; i >= 0; i--) 
        {
            invf[i] = (int) ((long) invf[i + 1] * (i + 1) % mod);
        }

        return new int[][]{f, invf};
    }
}