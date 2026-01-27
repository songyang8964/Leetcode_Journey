class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }

            }
        }
        return false;

    }

    private boolean backtrack(char[][] board, String word, int i, int j, int wordIndex) {
        // 终止条件
        if (wordIndex == word.length()) {
            return true;
        }
        // 步骤 B: 终止条件 - 失败
        // 1. 行索引越界
        // 2. 列索引越界
        // 3. 当前网格字符 != 我们要找的字符 (word.charAt(wordIndex))
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '?';
        // 步骤 D: 递归搜索 (向四个方向)
        // 只要有一个方向能走通，就返回 true
        // wordIndex + 1 表示下一步要找单词的下一个字符
        boolean found = backtrack(board, word, i + 1, j, wordIndex + 1) // 下
                || backtrack(board, word, i - 1, j, wordIndex + 1) // 上
                || backtrack(board, word, i, j + 1, wordIndex + 1) // 右
                || backtrack(board, word, i, j - 1, wordIndex + 1); // 左
        board[i][j] = temp;

        return found;
    }
}