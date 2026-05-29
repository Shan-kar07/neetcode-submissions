class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int total=0;
        int n=heights.length;

        Stack<Integer> idx =new Stack<>();


        for(int i=0;i<n;i++){

            while (!idx.isEmpty() && heights[idx.peek()]>=heights[i]){
                int nse=i;
                int element=heights[idx.pop()];
                
                int pse= idx.isEmpty()? -1:idx.peek();
                total=Math.max(total,(element*(nse-pse-1)));
            }
            idx.add(i);

        }
        while(!idx.isEmpty()){
            int element =heights[idx.pop()];

             int nse=n;
                int pse= idx.isEmpty()? -1:idx.peek();
                 total=Math.max(total,(element*(nse-pse-1)));
        }
        return total;
    }
}
