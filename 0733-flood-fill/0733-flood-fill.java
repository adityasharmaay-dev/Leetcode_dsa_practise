class Solution {
    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] vis = new boolean[n][m];
        int old = image[sr][sc];

        if(old == color) return image;

        bfs(sr, sc, image, vis, old, color);

        return image;
    }

    public void bfs(int r, int c, int[][] image, boolean[][] vis, int old, int color) {
        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        vis[r][c] = true;
        image[r][c] = color;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for(int i=0; i<4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                   image[nr][nc] == old && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
