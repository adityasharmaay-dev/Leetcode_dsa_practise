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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return Sum(root, low, high);
    }
    public int Sum(TreeNode root, int l, int h){
        if(root == null) return 0;
        int sum = (root.val>=l && root.val<=h)?root.val:0;
        return sum + Sum(root.left,l,h) + Sum(root.right,l,h);
    }
}