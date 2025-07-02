class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int longSub = 0;

        Set<Character> set = new HashSet<>();

        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);

            //if duplicate found,
            //shrink the window from start
            while (set.contains(cur)) {
                set.remove (s.charAt(i));
                i++;
            }
            set.add(cur);

            longSub = Math.max(longSub, j - i + 1);
        }
        return longSub;
    }
}