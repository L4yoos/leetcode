class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int currentNum : nums) {
            if (numsSet.contains(currentNum)) {
                return true;
            }
            numsSet.add(currentNum);
        }

        return false;
    }
}