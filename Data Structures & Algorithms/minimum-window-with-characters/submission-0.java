class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tcount=new HashMap<>();

        for(char ch : t.toCharArray()){
            tcount.put(ch,tcount.getOrDefault(ch, 0)+1);
        }
         int []res={-1,-1};
         int reslen=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> scount=new HashMap<>();
            for(int j=i;j<s.length();j++){
                 scount.put(s.charAt(j),scount.getOrDefault(s.charAt(j), 0)+1);

                 boolean flag=true;
                 for(char c:tcount.keySet()){
                    if(scount.getOrDefault(c, 0)<tcount.get(c)){
                        flag=false;
                        break;
                    }
                 }

                 if(flag && (j-i+1)<reslen){
                        reslen=j-i+1;
                        res[0]=i;
                        res[1]=j;
                 }
            }
        }

        return reslen == Integer.MAX_VALUE ? "":s.substring(res[0], res[1]+1);
    }
}
