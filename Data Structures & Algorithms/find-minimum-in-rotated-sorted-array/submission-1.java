class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int res=Integer.MAX_VALUE;
        while(l<=r){
            if(nums[l]<nums[r])
                res=Math.min(res,nums[l]);

            int mid =l+(r-l)/2;
            //remove the sorted portion and keep the updating the result
            //with the lowest of the sorted portion we cannot be saying that the min element is always in the unsorted portion
            if(nums[mid]>=nums[l]){
                res=Math.min(res,nums[l]);
                l=mid+1;
            }    else{
                 res=Math.min(res,nums[mid]);
                r=mid-1;
            }

        }
        return res;
    }
}
