class Solution {
    public void nextPermutation(int[] nums) {
        int pivot =-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot =i;
                break;
            }
        }
        if(pivot == -1){
            reverseNums(nums,0,nums.length-1);
            return;
        }

        for (int i=nums.length-1;i>=0;i--){
            if(nums[pivot]<nums[i]){
                 int temp =nums[i];
                nums[i]=nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }

        reverseNums(nums,pivot+1,nums.length-1);
    }
    public int[] reverseNums(int [] nums,int l,int r){
        while(l<=r){
            int temp =nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
        return nums;
    }
}