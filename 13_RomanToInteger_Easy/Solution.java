class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int letter = getValue(s.charAt(i));
            if (i + 1 < s.length()) {
                int nextLetter = getValue(s.charAt(i+1));

                if (nextLetter > letter) {
                    result -= letter;
                } else {
                    result += letter;
                }
            } else {
                result += letter;
            }
        }
        return result;
    }

    private int getValue(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}