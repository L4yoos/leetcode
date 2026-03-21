// 1. Simple solution with Nested loops (44ms)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

// 2. Solution with HashMap (2ms)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer index = complements.get(nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            complements.put(target - nums[i], i);
        }
        return new int[]{};
    }
}