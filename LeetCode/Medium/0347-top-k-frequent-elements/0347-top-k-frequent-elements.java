class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 根据优先队列进行排序
        // 我们需要依据元素对应的频率来决定优先级
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // a在map中对应的映射值大小
                return map.get(a) - map.get(b);
            }
        });

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            }
            // 情况 B：队列满了，需要决定是否替换
            // pq.getFront(): 获取堆顶元素。
            // 根据我们在 Freq 中写的 compareTo 逻辑，堆顶元素是“频次最小”的那个。
            else if (map.get(key) > map.get(pq.peek())) {
                pq.remove(); // 移除堆顶（踢走最弱的）
                pq.add(key);
            }
        }
        int n = pq.size();
        int[] res = new int[n];
        // 根据频次进行返回
        for (int i = 0; i < n; i++) {
            res[i] = pq.remove();

        }
        return res;
    }
}