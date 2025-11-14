class Solution {
    public int[][] rangeAddQueries(int n, int[][] Q) {
        int[][] res = new int[n][n];
        for (var q : Q) {
            int r0 = q[0], c0 = q[1], r1 = q[2]+1, c1 = q[3]+1;
            res[r0][c0]++;
            if (c1 < n) res[r0][c1]--;
            if (r1 < n) {
                res[r1][c0]--;
                if (c1 < n) res[r1][c1]++;
            }
        }

        for (int i = 0; i < n; i++) for (int j = 1; j < n; j++)
            res[i][j] += res[i][j-1];

        for (int i = 1; i < n; i++) for (int j = 0; j < n; j++)
            res[i][j] += res[i-1][j];

        return res;
    }
}