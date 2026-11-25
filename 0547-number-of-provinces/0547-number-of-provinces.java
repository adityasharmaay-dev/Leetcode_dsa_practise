class Solution {
    public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[v] = true;
        for(int it: adj.get(v)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<mat.length; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans;
    }
}