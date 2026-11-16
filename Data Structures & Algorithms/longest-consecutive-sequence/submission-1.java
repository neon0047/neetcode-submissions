class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int max = 0;
        for(int n: nums) hs.add(n);
        for(int n: nums){
            if(!hs.contains(n-1)){
                int count = 0;
                while(hs.contains(n)){
                    count++;
                    n++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
