class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anag=new HashMap<>();
        for(String word:strs){
            int [] count=new int[26];
            for(char c:word.toCharArray()){
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            anag.putIfAbsent(key,new ArrayList<>());
            anag.get(key).add(word);
        }
        return new ArrayList<>(anag.values());
    }
}
