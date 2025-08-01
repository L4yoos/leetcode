class Solution {
    public int searchInsert(int[] nums, int target) {

        //Binary Search
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (nums[low] >= target) {
            return low;
        } else {
            return low+1;
        }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     } else if (nums[i] > target) {
        //         return i;
        //     }
        // }

        // return nums.length;
    }
}