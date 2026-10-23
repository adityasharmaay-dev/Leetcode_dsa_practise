/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanced(root).bl;
    }
    public pair balanced(TreeNode root){
        if(root == null){
            return new pair();
        }
        pair l = balanced(root.left);
        pair r = balanced(root.right);
        pair s = new pair();
        s.ht = Math.max(l.ht, r.ht)+1;
        s.bl = l.bl && r.bl && Math.abs(l.ht-r.ht)<=1;
        return s;
    }
    class pair{
        int ht = -1;
        boolean bl = true;
    }
}