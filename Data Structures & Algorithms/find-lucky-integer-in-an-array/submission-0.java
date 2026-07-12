class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int a: arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        int res=-1;
        for(int num : map.keySet()){
            if(num==map.get(num)){
                res=Math.max(res,num);
            }
        }
        return res;
    }
}