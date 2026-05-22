class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(set.contains(ch)){
                    break;
                }
                set.add(ch);
            }
            res=Math.max(res,set.size());
        }
        return res;

    }
}
