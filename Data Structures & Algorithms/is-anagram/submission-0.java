class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqmap = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i<s.length(); i++){
            freqmap[s.charAt(i) - 'a']++;
            freqmap[t.charAt(i) - 'a']--;
        }
        for(int n: freqmap){
            if(n != 0) return false;
        }
        return true;
    }
}
