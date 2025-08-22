class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        boolean foundOne = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1){
                    foundOne = true;

                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        if (!foundOne) {
            return 0;
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}