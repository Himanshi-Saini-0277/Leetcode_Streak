class Solution(object):
    def dfs(self, i, j):
        if i < 0 or j < 0 or i >= self.n or j >= self.m or not self.grid_ii[i][j] or self.vst[i][j]:
            return

        self.vst[i][j] = True
        if not self.grid_i[i][j]:
            self.flag = False

        self.dfs(i + 1, j)
        self.dfs(i, j + 1)
        self.dfs(i - 1, j)
        self.dfs(i, j - 1)
    
    def countSubIslands(self, grid1, grid2):
        """
        :type grid1: List[List[int]]
        :type grid2: List[List[int]]
        :rtype: int
        """
        self.grid_i = grid1
        self.grid_ii = grid2
        self.n = len(grid1)
        self.m = len(grid1[0])
        self.vst = [[False] * self.m for _ in range(self.n)]
        ans = 0

        for i in range(self.n):
            for j in range(self.m):
                if not self.vst[i][j] and self.grid_ii[i][j]:
                    self.flag = True
                    self.dfs(i, j)
                    if self.flag:
                        ans += 1
        return ans