class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for (char se:s.toCharArray()){
            if(se=='('||se=='{'||se=='['){
                stack.push(se);
            }
            else{
                if(stack.isEmpty())
                return false;
                char top=stack.pop();
                if(se==')'&&top!='('||
                se=='}'&&top!='{'||
                se==']'&&top!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
