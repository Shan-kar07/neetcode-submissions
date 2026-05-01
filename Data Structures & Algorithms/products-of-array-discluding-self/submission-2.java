class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res= new int [nums.length];
        res[0]=1;
        int postfix=1;
        for(int i = 1; i < nums.length; i++ ){
            postfix *= nums[i-1];
            res[i] = postfix;
        }
        int prefix=1;
        for (int i=nums.length-1;i>=0;i--){
            res[i] *= prefix;
            prefix*=nums[i];
        }
        return res;
    }
}  
