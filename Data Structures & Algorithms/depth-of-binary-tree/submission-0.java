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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        Queue<TreeNode> level =new LinkedList<>();
        level.offer(root);
        while(!level.isEmpty())
        {
            int childs=level.size();
            for(int i=0;i<childs;i++){
                TreeNode node =level.poll();
                if(node.left!=null) level.offer(node.left);
                if(node.right!=null) level.offer(node.right);
            }
            count++;
        }

return count ;
        }
}
