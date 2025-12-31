class Solution {
     public String reverseWords(String s) {
        // 1. 将字符串转换为字符数组，因为 Java 的 String 是不可变的
        char[] chars = s.toCharArray();
        int n = chars.length;

        // =====================================================
        // 步骤 1：使用【快慢指针】移除多余空格
        // =====================================================
        int slow = 0; // 慢指针：指向“下一个要写入的位置”
        for (int fast = 0; fast < n; fast++) {
            // fast 负责寻找单词，只有遇到非空格才处理
            if (chars[fast] != ' ') {
                // 如果 slow != 0，说明这不是第一个单词，需要在单词前手动补一个空格
                if (slow != 0) {
                    chars[slow++] = ' ';
                }

                // 将 fast 指向的单词完整抄写到 slow 的位置
                while (fast < n && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        // 此时，chars 数组中 [0, slow-1] 的部分是清洗后的有效字符串
        // 后面的部分是垃圾数据，我们忽略它们

        // =====================================================
        // 步骤 2：反转整个有效字符串
        // =====================================================
        // 将 [0, slow-1] 范围内的字符全部翻转
        // 例子："the sky is blue" -> "eulb si yks eht"
        reverse(chars, 0, slow - 1);

        // =====================================================
        // 步骤 3：反转每个单词
        // =====================================================
        // 再次遍历，把每个单词内部翻转回来
        // 例子："eulb si yks eht" -> "blue is sky the"
        int start = 0; // 记录当前单词的起始位置
        for (int i = 0; i <= slow; i++) {
            // 当 i 走到有效长度的末尾 (i == slow) 或者遇到空格时，说明一个单词结束了
            if (i == slow || chars[i] == ' ') {
                // 反转当前单词，范围是 [start, i-1]
                reverse(chars, start, i - 1);
                // 更新 start 为下一个单词的起始位置
                start = i + 1;
            }
        }

        // =====================================================
        // 步骤 4：构造结果
        // =====================================================
        // 只取 chars 数组的前 slow 个字符构造新的字符串
        return new String(chars, 0, slow);
    }

    // 辅助函数：反转数组中指定范围 [left, right] 的字符
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}