class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> count=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!count.containsKey(nums[i])){
                count.put(nums[i],i);
            }else{
                int index=count.get(nums[i]);
                count.put(nums[i],i);
                if(Math.abs(index-i)<=k)
                    return true;    
            }
        }

        return false;
    }
}