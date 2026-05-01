class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        StringBuilder ans =new StringBuilder();
        int s1=0,s2=0;

        while (s1<m||s2<n){
            if(s1<m){
                ans.append(word1.charAt(s1++));
            }
             if(s2<n){
                ans.append(word2.charAt(s2++));
            }
        }
        return ans.toString();
    }
}