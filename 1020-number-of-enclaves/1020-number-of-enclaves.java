class Solution {
    public void dfs(int r, int c, int[][] grid, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        vis[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr, nc, grid, vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        // first row and last row
        for(int i=0; i<n ; i++){
            // first row
            if(grid[0][i]==1 && !vis[0][i]){
                dfs(0, i, grid, vis);
            }
            // last row
            if(grid[m-1][i]==1 && !vis[m-1][i]){
                dfs(m-1, i, grid, vis);
            }
        }
        // first col and last col
        for(int i=0; i<m; i++){
            // first col
            if(grid[i][0]==1 && !vis[i][0]){
                dfs(i, 0, grid, vis);
            }
            // last col
            if(grid[i][n-1]==1 && !vis[i][n-1]){
                dfs(i, n-1, grid, vis);
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}