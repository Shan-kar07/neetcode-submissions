class Solution {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s)){
                return true;
            }
        for(int i=0;i<s.length()-1;i++){
            String newS=s.substring(0, i) + s.substring(i+1);
            if(isPalindrome(newS)){
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String s){
        int l=0; int r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}