class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> prefix =new HashMap<>();
        prefix.put(0,1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int diff = sum-k;
            if (prefix.containsKey(diff)){
                count +=prefix.get(diff);
            }
                
                prefix.put(sum, prefix.getOrDefault(sum, 0)+1);
        } 
        return count;
    }
}