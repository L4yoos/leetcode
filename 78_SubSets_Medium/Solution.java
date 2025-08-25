class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(ans, subset, nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> subset, int[] nums , int start) {
        ans.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);

            backtrack(ans, subset, nums, i + 1);

            subset.remove(subset.size() - 1);
        }
    }
}