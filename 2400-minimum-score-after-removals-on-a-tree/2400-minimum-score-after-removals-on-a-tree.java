class Solution {
    int time = 0;
    int[] inTime, outTime, subtreeXor;
    List<Integer>[] tree;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        inTime = new int[n];
        outTime = new int[n];
        subtreeXor = new int[n];
        
        dfs(0, -1, nums);

        int totalXor = subtreeXor[0];
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            int u = isAncestor(a, b) ? b : a;
            
            for (int j = i + 1; j < edges.length; j++) {
                int c = edges[j][0], d = edges[j][1];
                int v = isAncestor(c, d) ? d : c;

                int xor1, xor2, xor3;

                if (isAncestor(u, v)) {
                    xor1 = subtreeXor[v];
                    xor2 = subtreeXor[u] ^ subtreeXor[v];
                    xor3 = totalXor ^ subtreeXor[u];
                } else if (isAncestor(v, u)) {
                    xor1 = subtreeXor[u];
                    xor2 = subtreeXor[v] ^ subtreeXor[u];
                    xor3 = totalXor ^ subtreeXor[v];
                } else {
                    xor1 = subtreeXor[u];
                    xor2 = subtreeXor[v];
                    xor3 = totalXor ^ xor1 ^ xor2;
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                res = Math.min(res, max - min);
            }
        }
        return res;
    }

    private void dfs(int node, int parent, int[] nums) {
        inTime[node] = time++;
        subtreeXor[node] = nums[node];

        for (int nei : tree[node]) {
            if (nei != parent) {
                dfs(nei, node, nums);
                subtreeXor[node] ^= subtreeXor[nei];
            }
        }

        outTime[node] = time++;
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}