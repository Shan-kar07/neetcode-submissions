class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());

        for(int s:stones){
            min.add(s);
        }
        while(min.size()>1){
        int first =min.poll();
        int second =min.poll();

        if(first>second){
            min.add(first-second);
        }
        }
        min.add(0);

        return min.poll();

    }
}
