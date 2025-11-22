class Solution {
        private class Freq implements Comparable<Freq> {
        int e, freq;

        // 构造器，对成员变量进行初始化
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        // 我们希望：频次越“低”的元素，反而被视为“优先级越高”（为了把它放在堆顶踢出去）。
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
              TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.remove(new Freq(key, map.get(key)));
            }
        }
        int n = pq.size(); // 或者 k
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pq.remove().e;
        }
        return ans;
    }
}