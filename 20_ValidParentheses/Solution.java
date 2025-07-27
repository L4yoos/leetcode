class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (mappings.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}