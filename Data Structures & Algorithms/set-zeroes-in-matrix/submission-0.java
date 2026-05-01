class Solution {
    public void setZeroes(int[][] matrix) {
        int ROW=matrix.length;
        int COL=matrix[0].length;
        boolean firstRow=false;
        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(matrix[r][c]==0){
                    matrix[0][c]=0;
                if(r>0)
                    matrix[r][0]=0;
                else
                    firstRow=true; 
                }        
            }
        }

        for(int r=1;r<ROW;r++){
            for(int c=1;c<COL;c++){
                if(matrix[0][c]==0 || matrix[r][0]==0)
                    matrix[r][c]=0;
            }
        }

        if(matrix[0][0]==0){
            for(int r=0;r<ROW;r++){
                matrix[r][0]=0;
            }
        }
        if(firstRow){
            for(int c=0;c<COL;c++){
                matrix[0][c]=0;
            }
        }
    }
}
