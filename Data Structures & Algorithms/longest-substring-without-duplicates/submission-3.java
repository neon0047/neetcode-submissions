class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet();
        int j = 0, max = 0;
        for(int i = 0; i<s.length(); i++){
            while(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(j++));
            }
            hs.add(s.charAt(i));
            max = Math.max(i-j+1, max);
        }
        return max;
    }
}
