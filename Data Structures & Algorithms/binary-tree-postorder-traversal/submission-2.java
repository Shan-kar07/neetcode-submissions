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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();

        TreeNode curr=root;

        while(curr!=null){

            if(curr.right==null){
                res.add(curr.val);
                curr=curr.left;
            }else{
                TreeNode prev=curr.right;
                while(prev.left!=null && prev.left!=curr){
                    prev=prev.left;
                }
                if(prev.left==null){
                    res.add(curr.val);
                    prev.left=curr;
                    curr=curr.right;
                }
                else{
                    prev.left=null;
                    curr=curr.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}