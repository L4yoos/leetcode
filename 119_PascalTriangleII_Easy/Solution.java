class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);

            for (int j = i - 1; j > 0; j--) {
                int sum = result.get(j) + result.get(j - 1);
                result.set(j, sum);
            }
        }

        return result;
    }
}