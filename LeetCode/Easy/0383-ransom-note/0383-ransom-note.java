class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        // 1. 创建一个长度为 26 的整型数组，用于统计字符频率
        // 默认初始值都是 0
        int[] count = new int[26];
        for(char c : magazine.toCharArray()){
            // c - 'a' 计算出字符所对应的索引(0-25)
            // ++ 表示将该位置的计数值 + 1
            count[c - 'a']++;

        }
        for(char c : ransomNote.toCharArray()){
            count[c -'a']--;
            if(count[c - 'a'] < 0){
                return false;
            }
        }
        return true;

    }
}