// 1. Simple Solution
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int number = x;
        int reverseNumber = 0;
        while (x != 0) {
            reverseNumber = (reverseNumber * 10) + (x % 10);
            x /= 10;
        }
        return reverseNumber == number;
    }
}

// 2. Interesing Solution
class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}