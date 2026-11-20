class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean ans = false;

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
         
        boolean vis[] = new boolean[n];
        if(!vis[src]){
            ans = bfs(src, dest, vis, adj);
        }

        return ans;

    }
    public boolean bfs(int src, int dest, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest) return true;

            for(int it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return false;
    }
}