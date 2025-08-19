class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount = 0;
        long currentZeros = 0;
        for (int num : nums) {
            if (num == 0) {
                currentZeros++;
            } else {
                totalCount += (currentZeros * (currentZeros + 1)) / 2;

                currentZeros = 0;
            }
        }

        totalCount += (currentZeros * (currentZeros + 1)) / 2;

        return totalCount;
    }
}