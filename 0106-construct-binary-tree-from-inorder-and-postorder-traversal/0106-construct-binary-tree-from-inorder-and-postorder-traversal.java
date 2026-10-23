class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return create(postorder, inorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode create(int[] post, int[] in, int ilo, int ihi, int plo, int phi) {
        if(ilo > ihi || plo > phi) return null;

        TreeNode node = new TreeNode(post[phi]);

        int idx = search(in, ilo, ihi, post[phi]);
        int nel = idx - ilo;

        node.left = create(post, in, ilo, idx-1, plo, plo+nel-1);
        node.right = create(post, in, idx+1, ihi, plo+nel, phi-1);

        return node;
    }

    public int search(int[] arr, int si, int ei, int target) {
        for(int i=si; i<=ei; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }
}