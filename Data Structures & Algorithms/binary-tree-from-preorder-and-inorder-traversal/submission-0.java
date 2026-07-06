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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);
        return root;
    }

    public TreeNode buildTree(int [] inorder,int instart,int inend,int [] preorder,int prestart,int preend,Map<Integer,Integer> map){

        if(instart>inend || prestart > preend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int rootnum=map.get(root.val);

        int numleft=rootnum-instart;

        root.left=buildTree(inorder,instart,rootnum-1,preorder,prestart+1,prestart+numleft,map);

        root.right=buildTree(inorder,rootnum+1,inend,preorder,prestart+numleft+1,preorder.length-1,map);

        return root;

    }
}
