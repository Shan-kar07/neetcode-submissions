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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> level=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }
        level.offer(root);

        while(!level.isEmpty()){
            int levelnodes=level.size();
            ArrayList<Integer> childnodes=new ArrayList<>();
            for(int i=0;i<levelnodes;i++){
                TreeNode node=level.poll();

                childnodes.add(node.val);

                if(node.left!=null) level.offer(node.left);
                if(node.right!=null) level.offer(node.right);
            }
            ans.add(childnodes);
        }
        return ans;
    }
}
