class Solution {
    class Pair {
        int r, c, t;
        Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int ans = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            int t = p.t;

            ans = Math.max(ans, t);

            for(int i=0; i<4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                   grid[nr][nc] == 1 && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr, nc, t+1));
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }
}
