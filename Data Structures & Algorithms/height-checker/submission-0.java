class Solution {
    public int heightChecker(int[] heights) {
        int count [] =new int [101];
        int res=0;
        for(int h:heights){
            count[h]++;
        }

        List<Integer> sorted =new ArrayList<>();

        for(int h=1;h<101;h++){
            int c=count[h];
            for(int i=0;i<c;i++){
                sorted.add(h);
            }
        }

        for(int i=0;i<heights.length;i++){
            if(heights[i]!=sorted.get(i)){
                res++;
            }
        }
        return res;
    }
}