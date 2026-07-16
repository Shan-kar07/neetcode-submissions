class Solution {
    public int leastInterval(char[] tasks, int n) {
       int freq[]=new int [26];
       PriorityQueue<Integer> maxheap =new PriorityQueue<>(Collections.reverseOrder());
       for (int task:tasks){
        freq[task-'A']++;
       }

       for(int f:freq){
        if(f>0){
            maxheap.offer(f);
        }
       }
       Queue<int[]> q= new LinkedList<>(); 
        int time =0;
        while(!maxheap.isEmpty() || !q.isEmpty()){
            time++;

            if(!maxheap.isEmpty()){
                int remaining = maxheap.poll();

                remaining--;

                if(remaining>0){
                    q.offer(new int[]{remaining,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxheap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
