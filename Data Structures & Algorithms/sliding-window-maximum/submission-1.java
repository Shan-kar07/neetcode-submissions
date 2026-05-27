class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int [] res=new int [n-k+1];
        int j=0;
        Deque<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.getFirst()<=i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.getLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            
            if(i>=k-1){
                res[j]=nums[q.getFirst()];
                j++;
            }
        }
        return res;
    }
}
