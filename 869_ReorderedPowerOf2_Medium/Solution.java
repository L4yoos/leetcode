class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] nDigitsCount = countDigits(n);

        for (int p = 1; p <= 1_000_000_000; p <<= 1) {
            int[] pDigitsCount = countDigits(p);

            if (Arrays.equals(nDigitsCount, pDigitsCount)) {
                return true;
            }

        }
        return false;
    }

    private int[] countDigits(int num) {
        int[] digitsCount = new int[10];

        if (num == 0) {
            digitsCount[0]++;
            return digitsCount;
        }

        while (num > 0) {
            int digit = num % 10;
            digitsCount[digit]++;
            num /= 10;
        }
        return digitsCount;
    }
}