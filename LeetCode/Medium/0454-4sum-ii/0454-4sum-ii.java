class Solution {
       public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 1. 定义一个 HashMap
        // Key: nums1[i] + nums2[j] 的和
        // Value: 这个和出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 2. 遍历前两个数组，统计和出现的频率
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                // map.getOrDefault(key, default) 
                // 作用：如果 map 中存在 sum，返回对应的值；否则返回 0。
                // 然后 +1 表示这个和又出现了一次。
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 3. 定义结果计数器
        int count = 0;

        // 4. 遍历后两个数组，在 Map 中寻找匹配的值
        for (int k : nums3) {
            for (int l : nums4) {
                int sum = k + l;
                // 我们需要找到 target，使得 sum + target = 0
                // 所以 target = -sum
                int target = -sum;

                // 5. 如果 Map 中包含这个 target，说明存在 nums1+nums2 = target
                if (map.containsKey(target)) {
                    // 将 map 中记录的次数累加到 count
                    // 注意：是加 map.get(target)，而不是加 1
                    // 因为 nums1 和 nums2 可能有多种组合得到这个 target
                    count += map.get(target);
                }
            }
        }

        return count;
}
}