class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // i 代表主串中当前的“起始位置”
        // 我们只需要遍历到 n - m，因为剩下的长度不够放 pattern 了
        for (int i = 0; i <= n - m; i++) {
            
            int j = 0; // j 代表模式串内部已经匹配的长度
            
            // 开始逐个比对
            // text.charAt(i + j) 意思是：从起始位置 i 往后数 j 个
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++; // 匹配成功，j 往后移，继续看下一个
            }

            // 如果 j 等于 m，说明 pattern 的每一个字符都比对成功了
            if (j == m) {
                return i; // 返回当前的起始位置
            }
            
            // 如果中间 break 了（while 条件不满足），
            // 循环会自动进入下一次 i++，也就是“第二轮尝试”
            // 此时 j 又被重置为 0
        }
        return -1; // 试完了所有位置都没找到
    }
}