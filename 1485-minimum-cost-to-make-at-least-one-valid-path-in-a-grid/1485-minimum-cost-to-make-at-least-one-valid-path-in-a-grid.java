class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        dist[0][0] = 0;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int x = curr[0], y = curr[1];
            int curDir = grid[x][y] - 1;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int cost = dist[x][y] + (dir == curDir ? 0 : 1);
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        if (dir == curDir) {
                            dq.offerFirst(new int[]{nx, ny});
                        } else {
                            dq.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}