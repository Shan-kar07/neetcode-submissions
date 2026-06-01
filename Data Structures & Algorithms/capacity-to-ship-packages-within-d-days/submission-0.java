class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int l=Arrays.stream(weights).max().getAsInt();
       int r= Arrays.stream(weights).sum();
       int res=0;

       while(l<=r){

        int mid =l+(r-l)/2;

        int d = finddays(weights,mid);

        if(d>days){
            l=mid+1;
        }else if(d<=days){
            r=mid-1;
            res=mid;
        }

       } 
       return res;
    }

    public int finddays(int [] weights,int capacity){
        int days=1;
        int currentload=0;
        for(int w :weights){
            if(w+currentload<=capacity){
                currentload+=w;
            }else{
                days++;
                currentload=w;
            }
        }
        return days;

    }
}