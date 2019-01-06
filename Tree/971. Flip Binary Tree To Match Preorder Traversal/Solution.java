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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result=new ArrayList<>();
        if (!helper(root,voyage,new int[1], result)){
            result=new ArrayList<>();
            result.add(-1);
        }
        return result;
    }
    private boolean helper(TreeNode root, int[] voyage, int[] index, List<Integer> result){
        if (root==null)
            return true;
        if (root.val!=voyage[index[0]]){
            return false;
        }
        index[0]++;
        if (root.left!=null&&root.right!=null&&root.left.val!=voyage[index[0]]&&root.right.val==voyage[index[0]]){
            TreeNode tmp=root.right;
            root.right=root.left;
            root.left=tmp;
            result.add(root.val);
        }
        return helper(root.left,voyage,index,result)&&helper(root.right,voyage,index,result);
    }
}