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
    //base case
    TreeNode prev=null, head=null;
    public TreeNode increasingBST(TreeNode root) {
        if (root==null){
            return root;
        }
        increasingBST(root.left);
        root.left=null;
        if (prev!=null)
            prev.right=root;
        if (head==null)
            head=root;
        prev=root;
        increasingBST(root.right);
        return head;
    }
}