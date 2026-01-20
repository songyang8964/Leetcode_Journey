class Solution {
    Map<Character, String> phoneMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    String inputDigits;

    public List<String> letterCombinations(String inputDigits) {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        if (inputDigits == null || inputDigits.length() == 0) {
            return result;
        }

        backtrack(inputDigits,0, new StringBuilder());
        return result;
    }

    private void backtrack(String inputDigits, int index, StringBuilder path) {
        if (index == inputDigits.length()) {
            result.add(path.toString());
            return;
        }
        // 这一层的数字是几？ digits.charAt(index)
        char digit = inputDigits.charAt(index);
        // 这个数字对应哪些字母？(比如 '2' -> "abc")
        String letters = phoneMap.get(digit);
        // 3. 宽度控制：开始横向扫描
        for (char c : letters.toCharArray()) {
            // 步骤 A：做选择。把当前字母 c 放到路径里
            path.append(c);
            // 带着刚才拼好的 path，把 index 加 1，去处理下一个数字
            backtrack(inputDigits,index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}