class Solution {
    List<List<String>> results = new ArrayList<>();
    char[][] board;


    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(n, 0);
        return results;

    }

    private void backtrack(int n, int row) {
        if (row == n) {
            results.add(construct());
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct() {
        List<String> path = new ArrayList<>();
        for (char[] r : board) {
            path.add(new String(r));
        }
        return path;
    }

    private boolean isValid(int row, int col, int n) {
        // if col is valid
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;

        }
        return true;
    }
}