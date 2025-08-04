class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int ways1 = 1;
        int ways2 = 2;

        for (int i = 3; i <= n; i++) {
            int currentWays = ways1 + ways2;

            ways1 = ways2;
            ways2 = currentWays;
        }

        return ways2;
    }
}