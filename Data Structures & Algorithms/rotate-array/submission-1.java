class Solution {
    public void rotate(int[] nums, int k) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int temp =nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
         k=k%nums.length;
        int n=k-1;
        int  z=0;
        while(z<n){
            int temp =nums[z];
            nums[z]=nums[n];
            nums[n]=temp;
            n--;
            z++;
        }
        int j=nums.length-1;
        int i=k;
        while(i<j){
            int temp =nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
            i++;

        }

    }
}