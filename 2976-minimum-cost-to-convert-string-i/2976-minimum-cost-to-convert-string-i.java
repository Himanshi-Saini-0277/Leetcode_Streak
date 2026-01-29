import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, 
char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        long INF = Long.MAX_VALUE / 2;

        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;
        int n = source.length();

        for (int i = 0; i < n; i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u == v) continue;
            if (dist[u][v] == INF) return -1;
            totalCost += dist[u][v];
        }

        return totalCost;
    }
}