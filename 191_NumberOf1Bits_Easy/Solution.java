class Solution {
    public int hammingWeight(int n) {
        int number = 0;
        while (n != 0) {
            number += n % 2;
            n = n >> 1;
        }
        return number;
    }
}