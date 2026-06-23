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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr=root;

        if(root==null){
            return null;
        }
        if(curr.val==key){
            return helper(root);
        }

        while(curr!=null){
            if(curr.val>key){
                if(curr.left!=null && curr.left.val == key){
                    curr.left=helper(curr.left);
                    break;
                }else{
                curr=curr.left;
                }
            }else{
                if(curr.right!=null && curr.right.val == key){
                    curr.right=helper(curr.right);
                    break;
                }else{
                curr=curr.right;
            }
        }

    }
    return root;
    }
    public TreeNode helper(TreeNode delNode){
        if(delNode.right==null){
            return delNode.left;
        }
        if(delNode.left==null){
            return delNode.right;
        }
        TreeNode rightChild=delNode.right;
        TreeNode lastRight=findLastNode(delNode.left);
        lastRight.right=rightChild;
        return delNode.left;
    }

    public TreeNode findLastNode(TreeNode node){
        if(node.right==null){
            return node;
        }
        return findLastNode(node.right);
    }
}