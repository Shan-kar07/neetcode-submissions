class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> indices=new HashMap<>();

        for(int num :nums){
           if(indices.containsKey(num))
                indices.put(num, indices.get(num)+1);
           else 
           indices.put(num,1);          
            }
            int maxvalue=0;
            int res=0;
        for(Map.Entry<Integer,Integer> entry : indices.entrySet()){
            if(entry.getValue()>maxvalue && entry.getValue()>nums.length/2 ){
                maxvalue=entry.getKey();
                res=maxvalue;
            }
        }
        return res;
    }
}