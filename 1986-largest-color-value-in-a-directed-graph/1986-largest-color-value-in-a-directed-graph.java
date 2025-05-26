import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
            int colorIdx = colors.charAt(i) - 'a';
            dp[i][colorIdx] = 1;
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            for (int neighbor : adj.get(node)) {
                for (int c = 0; c < 26; c++) {
                    int increment = (colors.charAt(neighbor) - 'a' == c) ? 1 : 0;
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c] + increment);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }

            for (int val : dp[node]) {
                maxColorValue = Math.max(maxColorValue, val);
            }
        }

        return visited == n ? maxColorValue : -1;
    }
}