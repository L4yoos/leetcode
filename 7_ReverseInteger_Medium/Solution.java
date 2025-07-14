class Solution {
    public int reverse(int x) {
        long reversedNum = 0;

        while (x != 0) {
            int digit = x % 10;

            if (reversedNum > Integer.MAX_VALUE / 10 ||
                    (reversedNum == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversedNum < Integer.MIN_VALUE / 10 ||
                    (reversedNum == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }

        return (int) reversedNum;
    }
}