class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);

        }
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (Integer intersection : intersectionSet) {
            result[index] = intersection;
            index++;
        }
    return result;
    }
}