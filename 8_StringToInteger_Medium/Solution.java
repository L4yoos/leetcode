class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        long result = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) {
            return 0;
        }

        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            result = result * 10 + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-result < Integer.MIN_VALUE)) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (sign * result);
    }
}