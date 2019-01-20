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
    //base case, if root==null, return 0
    //when parent node want? return positive number for have some coins remain, negative for needed coins
    //in the current level, get the coins from left and right, compute the number of coins remain after the current level
    //for example, left=-2, right=1, left subtree need 2 coins, which means, we must pass 2 into left substree, so result+=2,
    //and right has extra 1 coin, we must pass 1 into right substree, so result+=1
    int res=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if (root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        res+=Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
    }
}