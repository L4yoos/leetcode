class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .toArray();

        int totalLength = mergedArray.length;
        double median;

        if (totalLength % 2 == 1) {
            median = mergedArray[totalLength / 2];
        } else {
            int mid1 = mergedArray[totalLength / 2 - 1];
            int mid2 = mergedArray[totalLength / 2];
            median = (double) (mid1 + mid2) / 2.0;
        }

        return median;
    }
}