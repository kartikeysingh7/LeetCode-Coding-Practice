class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }
        int total = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == maxFrequency) {
                total += freq;
            }
        }
        return total;
    }
}