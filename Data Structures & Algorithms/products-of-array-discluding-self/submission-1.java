class Solution {
    public int[] productExceptSelf(int[] nums) {
        //to store the output an pre fix value
        int [] out =new int[nums.length];
        int [] post=new int [nums.length];
        int []temp=new int[nums.length];
        out[0]=1;
        post[nums.length-1]=1;
        //To claculate the prefix
        for (int i=1;i<nums.length;i++){
            out[i]=out[i-1]*nums[i-1];  
        }
        //To calculate the postfix 
        for(int i=nums.length-2;i>=0;i--){
            post[i]=post[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            temp[i]=out[i]*post[i];
        }
        return temp;
    }
}  
