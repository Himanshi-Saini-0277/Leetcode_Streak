// Added using AI
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        int[] h = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) h[j]++;
                else h[j] = 0;
            }
            int[] sh = h.clone();
            Arrays.sort(sh);
            for (int j = n - 1; j >= 0; j--) {
                if (sh[j] == 0) break;
                maxArea = Math.max(maxArea, sh[j] * (n - j));
            }
        }
        return maxArea;
    }
}