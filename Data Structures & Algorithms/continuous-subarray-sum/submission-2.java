class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       int total=0;
       HashMap<Integer,Integer> reminder =new HashMap<>();
        reminder.put(0,-1);
       for(int i=0;i<nums.length;i++){
            total +=nums[i];
            int rem=total%k;
            if(reminder.containsKey(rem) && i-reminder.get(rem)>1){
                return true;
            }
            else if (!reminder.containsKey(rem)){
                reminder.put(rem, i);
            }
       } 
       return false;
    }
}