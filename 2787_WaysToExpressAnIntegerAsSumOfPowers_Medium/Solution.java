class Solution {
    public int numberOfWays(int n, int x) {
        long MOD = 1_000_000_007;

        List<Integer> powers = new ArrayList<>();
        int i = 1;
        while (true) {
            long currentPower = (long) Math.pow(i, x);
            if (currentPower > n) {
                break;
            }
            powers.add((int) currentPower);
            i++;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int p : powers) {
            for (int j = n; j >= p; j--) {
                dp[j] = (dp[j] + dp[j - p]) % MOD;
            }
        }

        return (int) dp[n];
    }
}