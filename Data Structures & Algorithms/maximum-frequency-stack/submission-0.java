class FreqStack {
    Stack<Integer> stack;
    HashMap<Integer,Integer> count;
    public FreqStack() {
        stack =new Stack<>();
        count =new HashMap<>(); 
    }
    
    public void push(int val) {
        stack.push(val);
        count.put(val,count.getOrDefault(val,0)+1);
    }
    
    public int pop() {
        int maxcount = Collections.max(count.values());
        int i=stack.size()-1;
        while (count.get(stack.get(i))!=maxcount){
            i--;
        }
        int val=stack.remove(i);
        count.put(val, count.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */