class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentCombination, int openCount, int closeCount, int n) {
        if (openCount == n && closeCount == n) {
            result.add(currentCombination.toString());
            return;
        }

        if (openCount < n) {
            currentCombination.append('(');
            backtrack(result, currentCombination, openCount + 1, closeCount, n);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }

        if (closeCount < openCount) {
            currentCombination.append(')');
            backtrack(result, currentCombination, openCount, closeCount + 1, n);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
