class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length, min = complexity[0];
        int MOD = (int) 1e9 + 7;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= min) return 0;
        }

        long ft = 1;
        for (int i = 2; i < n; i++) {
            ft = (ft * i) % MOD;
        }

        return (int) ft;
    }
}