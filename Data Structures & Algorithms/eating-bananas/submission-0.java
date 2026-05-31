class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=0;
        int r=Arrays.stream(piles).max().getAsInt();
        int total =0;
        while(l<=r){
            int mid=l+(r-l)/2;
            total =hourstaken(piles,mid);
            if(total<=h){
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        return l;
    }

    public int hourstaken(int []piles,int mid){
        int totalhours=0;
        for(int i=0;i<piles.length;i++){
            totalhours+=Math.ceil((double)piles[i]/mid);
        }
        return totalhours;
    }
}
