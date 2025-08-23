class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minTotalArea = Integer.MAX_VALUE;

        for (int r1 = 0; r1 < m - 1; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                int area1 = findArea(grid, 0, 0, r1, n - 1);
                int area2 = findArea(grid, r1 + 1, 0, r2, n - 1);

                int area3 = findArea(grid, r2 + 1, 0, m - 1, n - 1);

                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }
            }
        }

        for (int c1 = 0; c1 < n - 1; c1++) {
            for (int c2 = c1 + 1; c2 < n; c2++) {
                int area1 = findArea(grid, 0, 0, m - 1, c1);
                int area2 = findArea(grid, 0, c1 + 1, m - 1, c2);
                int area3 = findArea(grid, 0, c2 + 1, m - 1, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }
            }
        }

        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                int area1 = findArea(grid, 0, 0, r, n - 1);
                int area2 = findArea(grid, r + 1, 0, m - 1, c);
                int area3 = findArea(grid, r + 1, c + 1, m - 1, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }

                area1 = findArea(grid, r + 1, 0, m - 1, n - 1);
                area2 = findArea(grid, 0, 0, r, c);
                area3 = findArea(grid, 0, c + 1, r, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }
            }
        }

        for (int c = 0; c < n - 1; c++) {
            for (int r = 0; r < m - 1; r++) {
                int area1 = findArea(grid, 0, 0, m - 1, c);
                int area2 = findArea(grid, 0, c + 1, r, n - 1);
                int area3 = findArea(grid, r + 1, c + 1, m - 1, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }

                area1 = findArea(grid, 0, c + 1, m - 1, n - 1);
                area2 = findArea(grid, 0, 0, r, c);
                area3 = findArea(grid, r + 1, 0, m - 1, c);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minTotalArea = Math.min(minTotalArea, area1 + area2 + area3);
                }
            }
        }

        return minTotalArea;
    }

    private int findArea(int[][] grid, int r1, int c1, int r2, int c2) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        boolean hasOnes = false;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    hasOnes = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        if (!hasOnes) {
            return 0;
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}