class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int num:asteroids){
        boolean destroyed=false;
        while(!stack.isEmpty()&&num<0&&stack.peek()>0){
            int top =stack.peek();

            if(top<Math.abs(num)){
                stack.pop();
            }else if(top==Math.abs(num)){
                destroyed=true;
                stack.pop();
                break;
            }else{
                destroyed=true;
                break;
            }
        }
        if(!destroyed){
            stack.push(num);
        }
    }
   
    
    return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}