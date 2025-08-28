class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                diagonalMap.putIfAbsent(key, key < 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));

                diagonalMap.get(key).offer(grid[i][j]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                grid[i][j] = diagonalMap.get(key).poll();
            }
        }

        return grid;
    }
}