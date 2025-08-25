class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0;
        boolean directionUp = true; //True - Top-Right, False - Bottom-Left

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[r][c];

            if (directionUp) {
                if (r == 0 && c < n - 1) {
                    directionUp = false;
                    c++;
                } else if (c == n - 1) {
                    directionUp = false;
                    r++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (c == 0 && r < m - 1) {
                    directionUp = true;
                    r++;
                } else if (r == m - 1) {
                    directionUp = true;
                    c++;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }
}