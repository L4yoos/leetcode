class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }

        double[] dp = new double[k + maxPts + 1];

        dp[0] = 1.0;

        double slidingWindowSum = 1.0;

        double finalProbability = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = slidingWindowSum / maxPts;

            if (i >= k) {
                finalProbability += dp[i];
            }

            if (i < k) {
                slidingWindowSum += dp[i];
            }
            if (i >= maxPts) {
                slidingWindowSum -= dp[i - maxPts];
            }
        }
        return finalProbability;
    }
}