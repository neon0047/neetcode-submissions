class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
        for(int key: hm.keySet()){
            pq.offer(new int[]{key, hm.get(key)});
        }
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
