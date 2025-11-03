

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // check the input string
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0; // left
        int j = 0; // right
        int maxLength = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        while (j <= s.length() - 1) {
            char charJ = s.charAt(j);
            windowCounts.put(charJ, windowCounts.getOrDefault(charJ, 0) + 1);
            if (windowCounts.size() == j - i + 1) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else {
                while (windowCounts.size() < j - i + 1) {
                    char charI = s.charAt(i);
                    windowCounts.put(charI, windowCounts.get(charI) - 1);
                    if (windowCounts.get(charI) == 0) {
                        windowCounts.remove(charI);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
