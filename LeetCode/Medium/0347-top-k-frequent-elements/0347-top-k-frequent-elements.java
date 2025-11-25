class Solution {
        private class Freq {
        int e, freq;

        // 构造器，对成员变量进行初始化
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

        private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
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

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
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