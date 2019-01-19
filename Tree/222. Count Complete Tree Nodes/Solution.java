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
    //time: O(2*log(n)*log(n))
    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        int left=getHeight(root, true);
        int right=getHeight(root, false);
        if (left==right){
            //complete tree
            return (1<<left)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int getHeight(TreeNode root, boolean toLeft){
        if (root==null)
            return 0;
        if (toLeft)
            return 1+getHeight(root.left, toLeft);
        else
            return 1+getHeight(root.right, toLeft);
    }
}