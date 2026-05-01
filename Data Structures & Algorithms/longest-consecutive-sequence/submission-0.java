class UnionFind {
    HashMap<Integer, Integer> parent;
    HashMap<Integer, Integer> size;

    UnionFind(Set<Integer> nums) {
        parent = new HashMap<>();
        size = new HashMap<>();
        for (Integer c : nums) {
            parent.put(c, c);
            size.put(c, 1);
        }
    }

    public Integer find(int x){
        if(parent.get(x)!=x){
            parent.put(x,find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(Integer x, Integer y) {
        Integer rootx=find(x);
        Integer rooty=find(y);
        if (rootx != rooty) {
            
                parent.put(rooty, rootx);
            
            size.put(rootx , size.get(rootx) + size.get(rooty));
        }
    }

    public Integer findMax() {
        Integer maxSize = 0;
        for (Integer m : size.values()) {
            if (m > maxSize) {
                maxSize = m;
            }
        }
        return maxSize;
    }

}

class Solution {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }
        UnionFind uf = new UnionFind(numset);

        for (Integer m : numset) {
            if (numset.contains(m + 1)) {
                uf.union(m, m + 1);
            }
        }
        return uf.findMax();

    }
}