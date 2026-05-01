class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high =Arrays.stream(nums).sum();
        int ans=0;
        while(low<=high){
            int mid =low+(high-low)/2;

            if(isValid(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[] nums,int k,int mid){
        int student=1;
        int total=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mid) return false;

            if(total+nums[i]<=mid){
                total+=nums[i];
            }else{
                student++;
                total=nums[i];
            }
        }
       return student>k?false:true;

    }
}