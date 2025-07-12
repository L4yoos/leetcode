class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int left1 = i;
            int right1 = i;
            while (left1 >= 0 && right1 < s.length() && s.charAt(left1) == s.charAt(right1)) {
                left1--;
                right1++;
            }
            int len1 = right1 - left1 - 1;

            int left2 = i;
            int right2 = i + 1;
            while (left2 >= 0 && right2 < s.length() && s.charAt(left2) == s.charAt(right2)) {
                left2--;
                right2++;
            }
            int len2 = right2 - left2 - 1;

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}