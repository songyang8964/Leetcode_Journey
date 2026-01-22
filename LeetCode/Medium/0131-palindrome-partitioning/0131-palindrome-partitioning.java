class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, path, result);
        return result;
    }

    private void backtracking(String s, int startIndex, List<String> path, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String sub = s.substring(startIndex, i + 1);
                path.add(sub);
                backtracking(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        while (startIndex < end) {
            if (s.charAt(startIndex) != s.charAt(end)) {
                return false;
            }
            startIndex++;
            end--;
        }
        return true;
    }
}