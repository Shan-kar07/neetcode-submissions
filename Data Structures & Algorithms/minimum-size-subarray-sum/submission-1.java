class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,sum=0,minlen=Integer.MAX_VALUE;
        for (int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                sum-=nums[l];
                minlen=Math.min(minlen,r-l+1);
                l++;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}