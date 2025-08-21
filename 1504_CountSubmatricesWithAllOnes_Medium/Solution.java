class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] heights = new int[n];
        int totalCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            totalCount += countRectanglesInHistogram(heights);
        }
        return totalCount;
    }

    private int countRectanglesInHistogram(int[] heights) {
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                count += minHeight;
            }
        }
        return count;
    }
}