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
    public int minCameraCover(TreeNode root) {
        int[] result=new int[1];
        int tmp= (dfs(root, result)==0)?1:0;
        result[0]+=tmp;
        return result[0];
    }
    private int dfs(TreeNode root, int[] result){
        if (root==null){
            return 2;
        }
        int left=dfs(root.left, result);
        int right=dfs(root.right, result);
        if (left==0||right==0){
            result[0]++;
            return 1;
        }else if (left==1||right==1){
            return 2;
        }
        return 0;
    }
}