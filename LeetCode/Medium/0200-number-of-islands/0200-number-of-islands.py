class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visited = [[False]*n for _ in range(m)]
        count = 0

        def dfs(i, j):
            if i < 0 or j < 0 or i >= m or j >= n:
                return 
            if visited[i][j]:
                return 
            if grid[i][j] == '0':
                return
            visited[i][j] = True
            dfs(i - 1, j)
            dfs(i + 1, j)
            dfs(i, j - 1)
            dfs(i, j + 1) 

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" and not visited[i][j]:
                    count = count + 1
                    dfs(i, j)
        return count
        