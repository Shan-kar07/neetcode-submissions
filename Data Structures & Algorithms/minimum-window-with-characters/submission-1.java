class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> tcount=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();

        int []res={-1,-1};
        int reslen=Integer.MAX_VALUE;
        int l=0;

        for(char ch : t.toCharArray()){
            tcount.put(ch,tcount.getOrDefault(ch, 0)+1);
        }
        int need=tcount.size();
        int have =0;
        for(int r=0;r<s.length();r++){
            
            window.put(s.charAt(r),window.getOrDefault(s.charAt(r), 0)+1);

            if(tcount.containsKey(s.charAt(r)) && window.get(s.charAt(r)).equals(tcount.get(s.charAt(r)))){
                have++;
            }
            while(have==need){
                if((r-l+1)<reslen){
                    reslen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char leftchar =s.charAt(l);
                window.put(leftchar, window.get(leftchar)-1);

                if(tcount.containsKey(leftchar)&&window.get(leftchar)<tcount.get(leftchar)){
                    have--;
                }
                l++;
            }
        }
        return reslen==Integer.MAX_VALUE?"":s.substring(res[0], res[1]+1);
    }
}
