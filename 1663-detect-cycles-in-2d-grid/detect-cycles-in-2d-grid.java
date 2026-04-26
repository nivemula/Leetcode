class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int r, int c, int pr, int pc, boolean[][] visited) {
        visited[r][c] = true;
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) continue;
            
            if (grid[nr][nc] != grid[r][c]) continue;
            
            if (!visited[nr][nc]) {
                if (dfs(grid, nr, nc, r, c, visited)) return true;
            } else if (nr != pr || nc != pc) {
                return true;
            }
        }
        
        return false;
    }
}