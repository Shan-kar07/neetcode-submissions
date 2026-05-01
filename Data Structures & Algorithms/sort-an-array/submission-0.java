class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }

    public static void mergesort(int [] nums ,int l ,int r){
         if(l>=r)return;

        int m = l + (r - l) / 2;
        mergesort(nums,l,m);
        mergesort(nums,m+1,r);
        merge(nums,l,m,r);

    }

    public static void merge(int [] arr ,int l, int m , int r){
        ArrayList<Integer> temp= new ArrayList<>();

        int i=l;
        int j=m+1;

        while(i<=m&&j<=r){
            if(arr[i]<arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=m){
            temp.add(arr[i]);
            i++;
        }

        while(j<=r){
            temp.add(arr[j]);
            j++;
        }

        for(int k=l;k<=r;k++){
            arr[k]=temp.get(k-l);
        }

    }
}