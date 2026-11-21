
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean path[] = new boolean[v];
        boolean safe[] = new boolean[v];

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(graph, i, vis, path, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(safe[i]) ans.add(i);
        }

        return ans;
    }

    public boolean dfs(int[][] graph, int i, boolean[] vis, boolean[] path, boolean[] safe){
        vis[i] = true;
        path[i] = true;
        safe[i] = false;

        for(int it: graph[i]){
            if(!vis[it]){
                if(dfs(graph, it, vis, path, safe)) return true;
            }
            else if(path[it]){
                return true;
            }
        }

        path[i] = false;
        safe[i] = true;
        return false;
    }
}
