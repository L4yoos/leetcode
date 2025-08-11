class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char digit = board[r][c];

                if (digit == '.') {
                    continue;
                }

                if (rows[r].contains(digit)) {
                    return false;
                }
                rows[r].add(digit);

                if (cols[c].contains(digit)) {
                    return false;
                }
                cols[c].add(digit);

                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex].contains(digit)) {
                    return false;
                }
                boxes[boxIndex].add(digit);
            }
        }

        return true;
    }
}