/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Solution 1
1. construct a sorted list, do it with binary search with k element

Solution 2
1. use priority queue, traver all node

Solution 3
1. use list, since all number will be appended at the end
2. min value of the list must be on the left side, max value of the list must be on the right side
*/
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        k = (k<=0)?1:k;
        boolean[] done = new boolean[1];
        closestKValues(result, root, target, k, done);
        return result;
    }
    private void closestKValues(List<Integer> result, TreeNode root, double target, int k, boolean[] done){
        if (root==null || done[0]){
            return;
        }
        closestKValues(result, root.left, target, k, done);
        if (result.size()>=k){
            int val = result.get(0);
            if (Math.abs(target-val)>Math.abs(target-root.val)){
                result.remove(0);
                result.add(root.val);
            }else{
                done[0] = true;
                return;
            }
        }else{
            result.add(root.val);
        }
        closestKValues(result, root.right, target, k, done);
    }
}