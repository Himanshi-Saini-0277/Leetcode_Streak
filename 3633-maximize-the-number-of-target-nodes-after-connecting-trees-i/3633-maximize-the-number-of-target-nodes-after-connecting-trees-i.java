import java.util.*;

class Solution {
    public int bfs(List<List<Integer>> graph, int k, int start, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int dist = 0, cnt = 0;
        visited[start] = true;
        while (!q.isEmpty() && dist <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                cnt++;
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
            dist++;
        }
        return cnt;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        List<List<Integer>> r1 = new ArrayList<>();
        List<List<Integer>> r2 = new ArrayList<>();

        for (int i = 0; i <= n; i++) r1.add(new ArrayList<>());
        for (int i = 0; i <= m; i++) r2.add(new ArrayList<>());

        for (int[] e : edges1) {
            r1.get(e[0]).add(e[1]);
            r1.get(e[1]).add(e[0]);
        }

        for (int[] e : edges2) {
            r2.get(e[0]).add(e[1]);
            r2.get(e[1]).add(e[0]);
        }

        int[] curr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            curr[i] = bfs(r1, k, i, n + 1);
        }

        int dc = 0;
        for (int i = 0; i <= m; i++) {
            dc = Math.max(dc, bfs(r2, k - 1, i, m + 1));
        }

        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = curr[i] + dc;
        }

        return ans;
    }
}