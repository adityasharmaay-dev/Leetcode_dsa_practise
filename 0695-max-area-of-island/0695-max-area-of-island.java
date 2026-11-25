class Solution {
    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        int ans = 0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int count = bfs(i, j, vis, grid);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public int bfs(int r, int c, boolean[][] vis, int[][] grid){
        vis[r][c] = true;
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));

        int m = grid.length;
        int n = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair node = q.poll();
            count++;
            int row = node.r;
            int col = node.c;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
                   grid[nr][nc] == 1 && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return count;
    }
}