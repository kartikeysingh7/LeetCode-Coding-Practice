class Solution {
    public int missingNumber(int[] nums) {
        Map<Integer, Boolean> numMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            numMap.put(num, true);
        }
        for (int i = 0; i <= n; i++) {
            if (!numMap.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }
}