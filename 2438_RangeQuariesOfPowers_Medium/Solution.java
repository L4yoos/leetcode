class Solution {
    public int[] productQueries(int n, int[][] queries) {
        long MOD = 1_000_000_007;

        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        Collections.sort(powers);

        long[] prefixProducts = new long[powers.size()];
        prefixProducts[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefixProducts[i] = (prefixProducts[i - 1] * powers.get(i)) % MOD;
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long result;
            if (left == 0) {
                result = prefixProducts[right];
            } else {
                result = 1;
                for (int j = left; j <= right; j++) {
                    result = (result * powers.get(j)) % MOD;
                }
            }
            answers[i] = (int) result;
        }
        return answers;
    }
}