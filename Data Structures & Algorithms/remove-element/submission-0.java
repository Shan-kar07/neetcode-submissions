class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                int temp=nums[i];
                nums[i]=nums[l];
                nums[l]=temp;
                count++;
                l++;
            }
            
        }
        return count;
    }
}