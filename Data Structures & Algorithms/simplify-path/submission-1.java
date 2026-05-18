class Solution {
    public String simplifyPath(String path) {
        String [] parts =path.split("/");

        Stack<String> stack =new Stack<>();

        for(String cur : parts){
            if(cur.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(cur.equals("")||cur.equals(".")){
                continue;
            }else{
                stack.push(cur);
            }
    }
    StringBuilder res=new StringBuilder();
    for(String ans : stack){
        res.append("/");
        res.append(ans);
    }
    return res.length()==0?"/":res.toString();
    }
}