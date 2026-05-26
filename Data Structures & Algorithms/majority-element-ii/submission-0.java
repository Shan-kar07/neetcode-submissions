class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> count =new HashMap<>();

        ArrayList<Integer> res=new ArrayList<>();
        
        int n= nums.length/3;

        for(int num: nums ){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        for(Integer key :count.keySet()){
             if(count.get(key)>n){
                res.add(key);
            }
        }

    return res;
    }
}