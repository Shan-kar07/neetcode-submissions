class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
            if(nums[l]!=nums[i]){
                l++;
                int temp=nums[l];
                nums[l]=nums[i];
                nums[i]=temp;
                count++;   
            }
        }
        return count;
    }
}