/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();
        if(k==0) {
            ans.add(target.val);
            return ans;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<=500; i++){
            adj.add(new ArrayList<>());
        }
        helper(adj, root);

        Queue<Integer> q = new LinkedList<>();
        q.add(target.val);
        int dep[] = new int[501];
        HashSet<Integer> set = new HashSet<>();
        set.add(target.val);
        while(!q.isEmpty()){
            int top = q.poll();
            for(int ele : adj.get(top)){
                if(!set.contains(ele)){
                    q.add(ele);
                    dep[ele] = dep[top]+1;
                    set.add(ele);
                }
            }
        }
        for(int i = 0; i<=500; i++){
            if(dep[i] == k) ans.add(i);
        }
        return ans;
    }
    public void helper(ArrayList<ArrayList<Integer>> adj , TreeNode root){
        if(root == null) return;
        if(root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
            helper(adj, root.left);
        }
        if(root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
            helper(adj, root.right);
        }
    }
}