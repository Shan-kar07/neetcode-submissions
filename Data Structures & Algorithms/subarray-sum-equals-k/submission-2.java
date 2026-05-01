class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int prefix=0;
        HashMap <Integer,Integer> prefixs=new HashMap<>();
        prefixs.put(0, 1);
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            int diff =prefix-k;
           count+= prefixs.getOrDefault(diff, 0);

           prefixs.put(prefix, prefixs.getOrDefault(prefix, 0)+1);
        }
        return count;
    }
}