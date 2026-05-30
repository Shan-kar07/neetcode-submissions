class Solution {
    public int mySqrt(int x) {
        int l=1;
        int r=x;
        int res=0;
        while (l<=r){
            int mid = l+(r-l)/2;
            if((long)mid*mid==x){
                res=mid;
                break;
            }else if((long)mid*mid<x){
                l=mid+1;
                res=mid;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}