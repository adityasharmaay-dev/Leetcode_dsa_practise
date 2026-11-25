class Solution {
    public int[] findOrder(int n, int[][] mat) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        int m = mat.length;
        for(int i=0; i<m; i++){
            adj.get(mat[i][1]).add(mat[i][0]);
        }
        int indegree[] = new int[n];
        for(int i=0; i<n; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            arr.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        int ans[] = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }

        if(ans.length != n) return new int[0];
        return ans;
    }
}