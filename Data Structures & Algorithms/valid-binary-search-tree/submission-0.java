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
    public boolean isValidBST(TreeNode root) {
        return validBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean validBST(TreeNode node,Integer left,Integer right){

        if(node==null){
            return true;
        }
        if(!(node.val>left && node.val<right))
                return false;
        return validBST(node.left,left,node.val) && validBST(node.right,node.val,right);        
    }
}
