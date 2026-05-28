class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1=-1;
        int num2=-1;
        int n=nums.length;
        int count1=0;
        int count2=0;

        for(int num: nums){

            if(num1==num){
                count1++;
            } else if(num2 == num){
                count2++;
            }else if(count1==0){
                count1=1;
                num1=num;
            }else if(count2==0){
                count2=1;
                num2=num;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==num1){
                count1++;
            }else if(num==num2){
                count2++;
            }
        }

        List<Integer> res=new ArrayList<>();

        if(count1>n/3){
            res.add(num1);
        }

        if(count2>n/3){
            res.add(num2);
        }

        return res;
        
    }
}