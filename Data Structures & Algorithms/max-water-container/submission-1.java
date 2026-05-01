class Solution {
    public int maxArea(int[] heights) {
        // My logic not working
        // int maxArea=Integer.MIN_VALUE;
        // for (int i=heights.length-1;i>=0;i--){
        //     int l=0;
        //     while(l<=i){
        //         if(heights[l]>=heights[i]){
        //         int b=i-l;
        //         int length =heights[i];
        //         int area=length*b;
        //         if(area>maxArea){
        //             maxArea=area;
        //         }
        //         l++;
        //         }
        //         else{
        //             l++;
        //         }
        //     }

        // }
        // return maxArea;
        int l=0;
        int r=heights.length-1;
        int res=0;
        while (l<r){
            int h=Math.min(heights[l],heights[r]);
            int area=(r-l)*h;
            res=Math.max(res,area);
            if(heights[l]<heights[r])
                l++;
            else
                r--;    
        }
        return res;
    }
}
