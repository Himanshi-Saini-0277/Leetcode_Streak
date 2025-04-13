class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long chakraLength) {
        long evenPositions = (chakraLength + 1) / 2;
        long oddPositions = chakraLength / 2;
        long evenWays = fastPower(5, evenPositions);
        long oddWays = fastPower(4, oddPositions);

        return (int)((evenWays * oddWays) % MOD);
    }

    long fastPower(long base, long power) {
        long result = 1;
        base %= MOD;

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            power /= 2;
        }
        return result;
    }
}