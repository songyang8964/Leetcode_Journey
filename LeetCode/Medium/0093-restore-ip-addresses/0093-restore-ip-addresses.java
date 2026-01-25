class Solution {
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0);
        return result;
    }

    private void backtrack(String s, int start, int segmentCount) {
        if (segmentCount == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        int remaining = s.length() - start;
        int segmentsNeeded = 4 - segmentCount;
        if (remaining < segmentsNeeded || remaining > segmentsNeeded * 3) {
            return;
        }
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String segment = s.substring(start, start + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, start + len, segmentCount + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        int len = segment.length();
        if(len == 0 || len >3 ) return false;
        // 这是字母，要用单引号
        if(len > 1 && segment.charAt(0) == '0') return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
        
    }
}