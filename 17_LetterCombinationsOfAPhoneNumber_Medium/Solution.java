class Solution {
    private final String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(0, new StringBuilder(), digits, result);

        return result;
    }

    private void backtrack(int index, StringBuilder currentCombination, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digitChar = digits.charAt(index);
        int digit = digitChar - '0';

        String letters = mapping[digit];

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);

            backtrack(index + 1, currentCombination, digits, result);

            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}