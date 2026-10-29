class Solution {
    public int findCircleNum(int[][] matrix) {
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int vis[] = new int[n+1];
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(vis[i] == 0){
                ans++;
                bfs(i, adj, vis);
            }
        }
        
        return ans;
    }
    public void bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node);
        vis[node] = 1;
        
        while(!q.isEmpty()){
            int x = q.poll();
            
            for(int i : adj.get(x)){
                if(vis[i] == 0){
                    vis[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}