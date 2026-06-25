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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> level=new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        level.offer(root);
        while(!level.isEmpty()){
            TreeNode rightside=null;

            int childs=level.size();

            for(int i=0;i<childs;i++){
                TreeNode node=level.poll();
                rightside=node;
                if(node.left!=null)level.offer(node.left);
                if(node.right!=null)level.offer(node.right);
            }

            if(rightside!=null){
                ans.add(rightside.val);
            }
        }
        return ans;
    }
}
