class Solution {
    class pair{
        int r;
        int c;
        int lvl;
        pair(int r,int c,int lvl){
            this.r = r;
            this.c = c;
            this.lvl = lvl;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean vis[][] = new boolean[m][n];
        int dist[][] = new int[m][n];
        Queue<pair> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            pair node = q.poll();
            int row = node.r;
            int col = node.c;
            int plvl = node.lvl;

            dist[row][col] = plvl;

            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new pair(nr,nc,plvl+1));
                }
            }
        }

        return dist;
    }
}