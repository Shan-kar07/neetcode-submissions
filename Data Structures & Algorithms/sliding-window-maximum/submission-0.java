class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int [] res=new int [k];
        ArrayList <Integer> result =new ArrayList<>();

        int l=0;

        for(int r=0;r<nums.length;r++){
            if((r-l+1)==k){
                int j=0;
                for(int i=l;i<=r;i++){
                    res[j]=nums[i];
                    j++;
                }
                Integer max=Arrays.stream(res).max().getAsInt();
                result.add(max);
                l++;
            }
        }
        return  result.stream().mapToInt(i -> i).toArray();
    }
}
