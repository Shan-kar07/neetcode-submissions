class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create frequency buckets where index represents the frequency
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: Fill the frequency buckets
        for (int key : count.keySet()) {
            int frequency = count.get(key);
            freq[frequency].add(key);
        }

        // Step 4: Collect the top k frequent elements starting from the highest frequency
        List<Integer> result = new ArrayList<>();
        for (int i = freq.length - 1; i >= 0 && result.size() < k; i--) {
            if (freq[i] != null) {
                result.addAll(freq[i]);
            }
        }

        // Step 5: Convert result to an int array of size k
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }
        return topK;
    }
}
